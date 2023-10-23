package view;

import javax.swing.*;

public class HomeComponent extends JPanel {
    private JButton game;
    private JButton record;
    private Router router;

    public HomeComponent() {
        router = Router.getInstance();
        game = new JButton("Play");
        game.addActionListener(e -> {
            String balance = JOptionPane.showInputDialog("Balance");
            if(balance != null) router.navigate("game-roulette", "balance",
                    balance);
        });
        record = new JButton("See History");
        record.addActionListener(e -> {
            router.navigate("history");
        });
        add(game);
        add(record);
    }
}
