package view;

import javax.swing.*;

public class HistoryComponent extends JPanel {
    private JButton home;
    private Router router;
    public HistoryComponent() {
        router = Router.getInstance();
        home = new JButton("Home");
        home.addActionListener(e -> {
            router.navigate("home");
        });
        add(home);
    }
}
