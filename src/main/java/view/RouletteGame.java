package view;

import logic.User;

import javax.swing.*;
import java.awt.*;

public class RouletteGame extends JFrame {
    private Router router;
    private String currentRoute;
    private JPanel mainPanel;
    public static User user;
    public static int idCurrentGame;
    public RouletteGame() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        router = Router.getInstance(this);
        buildRoutes();
        currentRoute = "home";

        user = new User();
        idCurrentGame = -1;

        setTitle("Roulette 🙂🛞");
        setBounds(0, 0,1200, 600);
        add(mainPanel);
        mainPanel.add(router.getComponent(currentRoute), BorderLayout.CENTER);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildRoutes() {
        router.addRoute("home", HomeComponent.class);
        router.addRoute("game-roulette", RouletteGameComponent.class);
        router.addRoute("history", HistoryComponent.class);
    }

    public void updateUI(){
        mainPanel.removeAll();
        mainPanel.add(router.getComponent(router.getCurrentRoute()),
                BorderLayout.CENTER);
        mainPanel.updateUI();
    }
}
