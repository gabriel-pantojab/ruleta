package view;

import db.GameService;
import logic.Game;

import java.util.Objects;

public class ControlGame {
    private Game game;
    private TableView table;
    private HandlerMouseEvent handlerMouseEvent;
    private GameService gameService;
    private Router router;

    public ControlGame(Game game, TableView table) {
        router = Router.getInstance();
        String createNewGame = router.getParam("create-game");
        gameService = GameService.getInstance();
        this.game = game;
        this.table = table;
        this.table.updateChipsAvailable(game.getChipsAvailable());
        this.table.setBalanceLabel(game.getBalance()+"");
        handlerMouseEvent = new HandlerMouseEvent(table, game);
        if(RouletteGame.user.getNickname() != null && Objects.equals(createNewGame, "true")) {
            int idGame = gameService.insert(game.getBalance(), RouletteGame.user.getId());
            RouletteGame.idCurrentGame = idGame;
            System.out.println(idGame);
        }
    }
}
