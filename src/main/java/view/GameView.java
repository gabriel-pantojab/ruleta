package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameView extends JPanel {
    private JLabel name;
    private JButton goGame;
    private JLabel balanceLabel;
    private JButton stat;
    private String currentBalance, balance, totalLostAmount, totalWinAmount;
    private int idGame;

    private Router router;

    public GameView(String  name, String balance, String currentBalance, String totalWinAmount, String totalLostAmount,
            int idGame) {
        setLayout(new GridLayout(1, 5, 10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        router = Router.getInstance();
        this.name = new JLabel(name);
        this.name.setForeground(Color.WHITE);
        this.name.setFont(new Font("arial", Font.BOLD, 16));
        this.balanceLabel = new JLabel("Balance: " + currentBalance);
        this.balanceLabel.setFont(new Font("arial", Font.BOLD, 16));
        this.balanceLabel.setForeground(Color.WHITE);
        this.idGame = idGame;
        this.balance = balance;
        this.totalWinAmount = totalWinAmount;
        this.totalLostAmount = totalLostAmount;
        this.currentBalance = currentBalance;
        goGame = new JButton("Go");
        goGame.addActionListener(e -> {
            RouletteGame.idCurrentGame = this.idGame;
            Map<String, String> params = new HashMap<String, String>();
            params.put("balance", currentBalance);
            params.put("create-game", "false");
            router.navigate("game-roulette", params);
        });
        stat = new JButton("Stat");
        stat.addActionListener(e->{
            JOptionPane.showMessageDialog(null,
                    "TotalWinAmount: "+totalWinAmount + "  "+"TotalLostAmount" +
                            ": "+totalLostAmount);
        });
        goGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        stat.setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Color(104, 104, 248));
        setPreferredSize(new Dimension(700, 50));
        setMaximumSize(new Dimension(700, 50));
        add(this.name);
        add(balanceLabel);
        add(goGame);
        add(stat);
    }
}
