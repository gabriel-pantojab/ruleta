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
        router = Router.getInstance();
        game.addActionListener(e -> {
            String balance = JOptionPane.showInputDialog("Ingrese el monto " +
                    "inicial");
            router.navigate("game-roulette", "balance", balance);
        });
        add(game);
    }

    public JButton getButton() {
        return game;
    }
}
