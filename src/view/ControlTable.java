package view;

import logic.Game;

public class ControlTable {
    private Game game;
    private TableView table;

    public ControlTable(Game game, TableView table) {
        this.game = game;
        this.table = table;
    }
}
