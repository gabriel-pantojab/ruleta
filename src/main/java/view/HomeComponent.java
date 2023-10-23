package view;

import db.UserService;
import logic.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class HomeComponent extends JPanel {
    private JButton game;
    private JButton record;
    private Router router;
    private JButton auth;
    private JButton signUp;
    private JLabel nickName;
    private UserService userService;


    public HomeComponent() {
        userService = UserService.getInstance();
        setLayout(null);
        router = Router.getInstance();
        game = new JButton("Play");
        game.addActionListener(e -> {
            String balance = JOptionPane.showInputDialog("Balance");
            if(balance != null) router.navigate("game-roulette", "balance",
                    balance);
        });
        record = new JButton("See History");
        record.addActionListener(e -> {
            router.navigate("history");
        });

        auth = new JButton("SignIn");
        auth.addActionListener(e -> {
            if(RouletteGame.user.getNickname() == null) {
                showRegistrationDialog();
            }else {
                JOptionPane.showMessageDialog(null, "Thanks, come back soon");
                logout();
                update();
            }
        });
        auth.setBounds(1080, 60, 80, 30);

        signUp = new JButton("SignUp");
        signUp.setBounds(1080, 25, 80, 30);
        signUp.addActionListener(e->{
            showSignUpDialog();
        });

        nickName = new JLabel("");//RouletteGame.user.getNickName();
        nickName.setForeground(Color.WHITE);
        nickName.setFont(new Font("arial", Font.BOLD, 15));
        nickName.setBounds(980, 25, 130, 30);

        game.setFont(new Font("arial", Font.BOLD, 17));
        game.setBounds(387, 430, 70, 40);
        record.setBounds(487, 430, 130, 40);
        record.setFont(new Font("arial", Font.BOLD, 17));

        add(game);
        add(record);
        add(auth);
        add(nickName);
        add(signUp);
    }

    public void update() {
        removeAll();
        add(game);
        add(record);
        if(RouletteGame.user.getNickname() != null) {
            nickName.setText(RouletteGame.user.getNickname());
            auth.setText("Logout");
            auth.setLocation(1080, 25);
            add(auth);
            add(nickName);
        }else {
            nickName.setText("");
            auth.setText("SignIn");
            auth.setLocation(1080, 60);
            add(auth);
            add(signUp);
        }
        updateUI();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondoImage = Toolkit.getDefaultToolkit().getImage(
                "./src/main/assets/fondo2.jpg");
        g.drawImage(fondoImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void showRegistrationDialog() {
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 15, 5));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "User " +
                        "Registration",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try{
                //guardar en db
                String nickN = usernameField.getText().trim();
                String pass = passwordField.getText().trim();
                User newUser = new User(nickN, pass);
                userService.insert(newUser);
                RouletteGame.user.setNickname(nickN);
                RouletteGame.user.setPassword(pass);
                int id = userService.selectID(nickN, pass);
                RouletteGame.user.setId(id);
                JOptionPane.showMessageDialog(null, "Welcome " + usernameField.getText());
                update();
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "User already exist 🫣" + e.getMessage());
            }
        }
    }

    public void showSignUpDialog() {
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 15, 5));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, "SignUp",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try{
                String nickN = usernameField.getText().trim();
                String pass = passwordField.getText().trim();
                int id = userService.selectID(nickN, pass);
                RouletteGame.user.setId(id);
                RouletteGame.user.setNickname(nickN);
                RouletteGame.user.setPassword(pass);
                JOptionPane.showMessageDialog(null, "Welcome " + usernameField.getText());
                update();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nickname or password " +
                        "incorrect");
            }
        }
    }

    public void logout() {
        RouletteGame.user.setId(-1);
        RouletteGame.user.setPassword(null);
        RouletteGame.user.setNickname(null);
    }
}
