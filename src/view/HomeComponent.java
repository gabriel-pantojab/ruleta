package view;

import javax.swing.*;

public class HomeComponent extends JPanel {
    private JButton game;
    private Router router;

    public HomeComponent() {
        router = Router.getInstance();
        game = new JButton("Play");
        game.addActionListener(e -> {
            String balance = JOptionPane.showInputDialog("Balance");
            router.navigate("game-roulette", "balance", balance);
        });
        add(game);
    }
}
