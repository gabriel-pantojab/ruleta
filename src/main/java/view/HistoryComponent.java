package view;

import db.GameData;
import db.GameService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HistoryComponent extends JPanel {
    private JButton home;
    private  JLabel title;
    private Router router;
    private GameService gameService;
    private ArrayList<GameData> games;
    private JPanel gamesPanel, header;
    public HistoryComponent() {
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);
        gameService = GameService.getInstance();
        router = Router.getInstance();

        header = new JPanel();

        title = new JLabel("History");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("arial", Font.BOLD, 30));
        title.setBounds(550, 0, 200, 33);

        home = new JButton("Home");
        home.addActionListener(e -> {
            router.navigate("home");
        });
        home.setBounds(1100, 0, 70, 30);
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));

        getRounds();
        gamesPanel = new JPanel();
        gamesPanel.setOpaque(false);
        gamesPanel.setLayout(new BoxLayout(gamesPanel, BoxLayout.Y_AXIS));

        int i = 1;
        for(GameData g : games) {
            gamesPanel.add(new GameView("Game "+i+"", g.getBalance()+"",
                    g.getCurrentBalance()+"",
                    g.getTotalWinAmount(), g.getTotalLostAmount(), g.getIdGame()));
            i++;
            gamesPanel.add(Box.createVerticalStrut(10));
        }


        header.setOpaque(false);
        header.setLayout(null);
        header.add(title);
        header.add(home);
        header.setPreferredSize(new Dimension(1200, 40));
        header.setMaximumSize(new Dimension(1200, 40));
        header.setMinimumSize(new Dimension(1200, 40));

        add(Box.createVerticalStrut(20));
        add(header);
        add(Box.createVerticalStrut(20));
        add(gamesPanel);
        add(Box.createVerticalStrut(20));
    }

    public void getRounds() {
        games = gameService.selectGamesUser(RouletteGame.user.getId());
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondoImage = Toolkit.getDefaultToolkit().getImage(
                "./src/main/assets/history.jpg");
        g.drawImage(fondoImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
