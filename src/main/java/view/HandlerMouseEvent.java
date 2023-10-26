package view;

import db.GameService;
import db.RoundService;
import logic.Bet;
import logic.Game;
import logic.Pocket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class HandlerMouseEvent extends MouseAdapter implements ActionListener {
    private TableView table;
    private Game game;
    private boolean run;
    private Router router;
    private GameService gameService;
    private RoundService roundService;
    public HandlerMouseEvent(TableView table, Game game) {
        roundService = RoundService.getInstance();
        gameService = GameService.getInstance();
        router = Router.getInstance();
        this.table = table;
        this.table.addMouseListener(this);
        this.table.addMouseMotionListener(this);
        this.table.getSpinButton().addActionListener(this);
        this.table.getClearGridButton().addActionListener(this);
        this.table.getGoHome().addActionListener(this);
        this.game = game;
        this.run = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(run) return;
        int x = e.getX();
        int y = e.getY();
        Bet bet = table.toBet(x, y);
        if(bet != null) {
            boolean success = game.toBetInRound(bet);
            if(success) {
                table.getSpinButton().setEnabled(true);
                table.getClearGridButton().setEnabled(true);
                table.setBalanceLabel(game.getBalance()+"");
                table.setTotalBetLabel(game.getCurrentRound().getTotalBet()+"");
                table.updateChipsAvailable(game.getChipsAvailable());
            }
        }
        for(ChipView c : table.getChipsAvailable()) {
            if(c.contains(x, y)) {
                table.setIndexCurrentChip(table.getChipsAvailable().indexOf(c));
                table.setCurrentChip((ChipView) c.clone());
                table.getCurrentChip().setRadio(17);
                table.getCurrentChip().setFontSize(10);
                table.getCurrentChip().setActive(true);
            }
        }
        table.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if(run) return;
        int x = e.getX();
        int y = e.getY();
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        if(table.getCurrentChip() != null) {
            for(BettingGridBoxView b : table.getBoxes()) {
                TypeBet type = table.getTypeBet(x, y).getType();
                if(b.clickBorder(x, y)) {
                    if(type.equals(TypeBet.LINE) || type.equals(TypeBet.STREET)) {
                        int v = Integer.parseInt(b.getValue().trim());
                        indexes.add(v);
                    }else {
                        b.setSelect(type.equals(TypeBet.ADJACENT) || type.equals(
                                TypeBet.ANGLE));
                    }
                }else b.setSelect(b.contains(x, y));
            }
            for(BetBox b : table.getBetBoxes()) {
                b.setSelect(b.contains(x, y));
            }
            table.setLocationCurrentChip(x, y);
        }
        table.selectBoxes(indexes);
        table.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s.equals(table.getSpinButton())) {
            Thread r = new Thread(() -> {
                run = true;
                table.setIndexCurrentChip(-1);
                table.repaint();
                table.setCurrentChip(null);
                table.spinRoulette();
                table.getSpinButton().setEnabled(false);
                table.getClearGridButton().setEnabled(false);
                try{
                    Thread.sleep(6500);
                    Pocket pocket = game.spinRoulette();
                    JOptionPane.showMessageDialog(null,
                            pocket.getColor() +": "+ pocket.getValue());
                    long winAmount = game.getWinAmount(pocket);
                    JOptionPane.showMessageDialog(null,
                            "Win Amount: " + winAmount);
                    if(RouletteGame.user.getNickname() != null) {
                        roundService.insert(winAmount,
                                Math.max(game.getCurrentRound().getTotalBet() - winAmount, 0)
                                , game.getCurrentRound().getTotalBet(), RouletteGame.idCurrentGame);
                    }
                    game.updateBalance(winAmount);
                    table.updateChipsAvailable(game.getChipsAvailable());
                    table.setBalanceLabel(game.getBalance()+"");
                    table.setTotalBetLabel("0");
                    table.clearGrid();
                    game.createNewRound();
                    if(game.getBalance() == 0) {
                        JOptionPane.showMessageDialog(null,"GAME OVER");
                        router.navigate("home");
                    }
                    table.repaint();
                    run = false;
                }catch (Exception ignored){}
            });
            r.start();
        }else if(s.equals(table.getClearGridButton())) {
            table.clearGrid();
            table.setIndexCurrentChip(-1);
            table.setCurrentChip(null);
            game.resetRound();
            table.setBalanceLabel(game.getBalance()+"");
            table.setTotalBetLabel("0");
            table.getClearGridButton().setEnabled(false);
            table.getSpinButton().setEnabled(false);
            table.updateChipsAvailable(game.getChipsAvailable());
            table.repaint();
        }else if(s.equals(table.getGoHome())) {
            if(RouletteGame.user.getNickname() == null) {
                router.navigate("home");
                return;
            }
            JOptionPane.showMessageDialog(null, "Save Game ✅");
            router.navigate("home");
        }
    }
}
