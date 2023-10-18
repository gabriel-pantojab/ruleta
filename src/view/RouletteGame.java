package view;

import javax.swing.*;

public class RouletteGame extends JFrame {
    public RouletteGame() {
        setTitle("Roulette 🙂🛞");
        TableView table = new TableView();
        setBounds(0, 0,1000, 600);
        add(table);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
