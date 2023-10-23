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
            Router router = Router.getInstance();
            long balance = Long.parseLong(router.getParam("balance"));
            setLayout(new BorderLayout());
            game = new Game(balance);
            table = new TableView(game.getBettingGrid());
            control = new ControlGame(game, table);
            table.updateChipsAvailable(game.getChipsAvailable());
            add(table, BorderLayout.CENTER);
        }catch (Exception e){
            System.out.println("error" + e);
        }
    }
}
