package view;

import logic.Game;

import javax.swing.*;
import java.awt.*;

public class RouletteGameComponent extends JPanel {
    private Game game;
    private TableView table;
    private ControlGame control;

    public RouletteGameComponent() {
        try{
            Router router = Router.getInstance(null);
            setLayout(new BorderLayout());
            game = new Game(2500L);
            table = new TableView(game.getBettingGrid());
            control = new ControlGame(game, table);
            add(table, BorderLayout.CENTER);
            JButton b = new JButton("Home");
            //add(b, BorderLayout.NORTH);
            b.addActionListener(e -> router.setCurrentRoute("home"));
        }catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
