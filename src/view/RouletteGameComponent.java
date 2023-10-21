package view;

import logic.Game;

import javax.swing.*;

public class RouletteGameComponent extends JPanel {
    private Game game;
    private TableView table;
    private ControlGame control;

    public RouletteGameComponent() {
        try{
            game = new Game(0);
            table = new TableView(game.getBettingGrid());
            control = new ControlGame(game, table);
            add(table);
        }catch (Exception e){}
    }
}
