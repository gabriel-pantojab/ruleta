package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeComponent extends JPanel {
    private JButton game;
    private Router router;
    public HomeComponent() {
        game = new JButton("Play");
        router = Router.getInstance(null);
        game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                router.setCurrentRoute("game-roulette");
            }
        });
        add(game);
    }

    public JButton getButton() {
        return game;
    }
}
