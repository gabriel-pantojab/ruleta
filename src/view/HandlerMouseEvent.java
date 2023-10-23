package view;

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
    public HandlerMouseEvent(TableView table, Game game) {
        this.table = table;
        this.table.addMouseListener(this);
        this.table.addMouseMotionListener(this);
        this.table.getSpinButton().addActionListener(this);
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Bet bet = table.toBet(x, y);
        game.toBetInRound(bet);
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
        int x = e.getX();
        int y = e.getY();
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        if(table.getCurrentChip() != null) {
            for(BettingGridBoxView b : table.getBoxes()) {
                if(b.clickBottomBorder(x, y) || b.clickTopBorder(x, y)) {
                    String type = table.getTypeBet(x, y).getType();
                    if(type.equals("line") || type.equals("street")) {
                        int v = Integer.parseInt(b.getValue().trim());
                        indexs.add(v);
                    }else b.setSelect(b.clickBorder(x, y));
                }else b.setSelect(b.contains(x, y) || b.clickBorder(x, y));
            }
            for(BetBox b : table.getBetBoxes()) {
                b.setSelect(b.contains(x, y));
            }
            table.setLocationCurrentChip(x, y);
        }
        table.selectBoxes(indexs);
        table.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object s = e.getSource();
        if(s.equals(table.getSpinButton())) {
            Thread r = new Thread(() -> {
                table.spinRoulette();
                table.getSpinButton().setEnabled(false);
                try{
                    Thread.sleep(6500);
                    table.getSpinButton().setEnabled(true);
                    Pocket pocket = game.spinRoulette();
                    JOptionPane.showMessageDialog(null, pocket.getValue());
                    long winAmount = game.getWinAmount(pocket);
                    game.updateBalance(winAmount);
                    table.setBalanceLabel(game.getBalance()+"");
                }catch (Exception ignored){}
            });
            r.start();
        }
    }
}
