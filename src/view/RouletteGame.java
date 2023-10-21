package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RouletteGame extends JFrame implements ActionListener {
    private Router router;
    private String currentRoute;
    private JPanel mainPanel;
    public RouletteGame(TableView table) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        router = Router.getInstance(this);
        buildRoutes();
        currentRoute = "home";
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
        router.addRoute("home", new HomeComponent());
        router.addRoute("game-roulette", new RouletteGameComponent());
    }

    public void updateUI(){
        mainPanel.removeAll();
        mainPanel.add(router.getComponent(router.getCurrentRoute()),
                BorderLayout.CENTER);
        mainPanel.updateUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
