package view;

import logic.User;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

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

        Thread play = new Thread(){
            public void run() {
                Clip clip = null;
                try {
                    AudioInputStream audioInputStream =
                            AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getResource(
                                    "/resources/game.wav")));
                    clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.start();
                } catch (Exception e) {
                    if (clip != null && clip.isOpen()) {
                        clip.close();
                    }
                }
            }
        };
        play.start();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (play.isAlive()) {
                    play.interrupt();
                }
                System.exit(0);
            }
        });
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
