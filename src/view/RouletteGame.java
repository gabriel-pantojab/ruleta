package view;

import javax.swing.*;

public class RouletteGame extends JFrame {
    public RouletteGame(TableView table) {
        setTitle("Roulette 🙂🛞");
        setBounds(0, 0,960, 600);
        add(table);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
