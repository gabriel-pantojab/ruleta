package view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HomeComponent extends JPanel {
    private JButton game;
    private JButton record;
    private Router router;


    public HomeComponent() {
        setLayout(null);
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
        game.setFont(new Font("arial", Font.BOLD, 17));
        game.setBounds(387, 430, 70, 40);
        record.setBounds(487, 430, 130, 40);
        record.setFont(new Font("arial", Font.BOLD, 17));
        add(game);
        add(record);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondoImage = Toolkit.getDefaultToolkit().getImage("src/assets" +
                "/fondo2.jpg");
        g.drawImage(fondoImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
