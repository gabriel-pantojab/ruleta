package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeComponent extends JPanel {
    private JButton game;
    private Router router;
    public HomeComponent() {
        game = new JButton("Play");
        router = Router.getInstance(null);
        game.addActionListener(e -> {
            router.navigate("game-roulette", "balance", "25000");
        });
        add(game);
    }

    public JButton getButton() {
        return game;
    }
}
