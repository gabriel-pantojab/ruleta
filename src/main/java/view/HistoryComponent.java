package view;

import db.GameData;
import db.GameService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryComponent extends JPanel {
    private JButton home;
    private Router router;
    private GameService gameService;
    private ArrayList<GameData> games;
    private JPanel gamesPanel;
    public HistoryComponent() {
        gameService = GameService.getInstance();
        router = Router.getInstance();
        home = new JButton("Home");
        home.addActionListener(e -> {
            router.navigate("home");
        });
        getRounds();
        gamesPanel = new JPanel();
        gamesPanel.setLayout(new GridLayout(games.size(),1));
        int i = 1;
        for(GameData g : games) {
            gamesPanel.add(new GameView("Game "+i+"", g.getBalance()+"",
                    g.getTotalWinAmount(), g.getTotalLostAmount()));
                    i++;
        }
        add(home, BorderLayout.NORTH);
        add(gamesPanel, BorderLayout.CENTER);
    }

    public void getRounds() {
        games = gameService.selectGamesUser(RouletteGame.user.getId());
    }
}
