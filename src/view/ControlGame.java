package view;

import logic.Game;

public class ControlGame {
    private Game game;
    private TableView table;
    private HandlerMouseEvent handlerMouseEvent;

    public ControlGame(Game game, TableView table) {
        this.game = game;
        this.table = table;
        this.table.updateChipsAvailable(game.getChipsAvailable());
        this.table.setBalanceLabel(game.getBalance()+"");
        handlerMouseEvent = new HandlerMouseEvent(table, game);
    }
}
