package view;

import logic.Game;

public class ControlGame {
    private Game game;
    private TableView table;

    public ControlGame(Game game, TableView table) {
        this.game = game;
        this.table = table;
    }
}
