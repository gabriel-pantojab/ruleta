package view;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private JLabel name;
    private JButton goGame;
    private JLabel balanceLabel;
    private JButton stat;
    private String balance, totalLostAmount, totalWinAmount;

    private Router router;

    public GameView(String  name, String balance, String totalLostAmount,
                    String totalWinAmount) {
        setLayout(new GridLayout(1, 5, 10, 10));
        router = Router.getInstance();
        this.name = new JLabel(name);
        this.balanceLabel = new JLabel("Balance: " + balance);
        this.balance = balance;
        this.totalWinAmount = totalWinAmount;
        this.totalLostAmount = totalLostAmount;
        goGame = new JButton("Go");
        goGame.addActionListener(e -> {
            router.navigate("game-roulette", "balance", balance);
        });
        stat = new JButton("Stat");
        stat.addActionListener(e->{
            JOptionPane.showMessageDialog(null,
                    "TotalWinAmount: "+totalWinAmount + "  "+"TotalLostAmount" +
                            ": "+totalLostAmount);
        });
        setPreferredSize(new Dimension(500, 50));
        add(this.name);
        add(balanceLabel);
        add(goGame);
        add(stat);
    }
}
