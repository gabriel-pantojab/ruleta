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
        JLabel love = new JLabel("Hola Mi Amooooooor :3");
        love.setFont(new Font("arial", Font.BOLD, 30));
        add(love);
        router = Router.getInstance(null);
        game.addActionListener(e -> router.setCurrentRoute("game-roulette"));
        add(game);
    }

    public JButton getButton() {
        return game;
    }
}
