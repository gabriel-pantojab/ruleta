package view;

import db.GameService;
import logic.Game;

public class ControlGame {
    private Game game;
    private TableView table;
    private HandlerMouseEvent handlerMouseEvent;
    private GameService gameService;

    public ControlGame(Game game, TableView table) {
        gameService = GameService.getInstance();
        this.game = game;
        this.table = table;
        this.table.updateChipsAvailable(game.getChipsAvailable());
        this.table.setBalanceLabel(game.getBalance()+"");
        handlerMouseEvent = new HandlerMouseEvent(table, game);
        if(RouletteGame.user.getNickname() != null) gameService.insert(game,
                RouletteGame.user.getId(),
                0, 0);
    }
}
