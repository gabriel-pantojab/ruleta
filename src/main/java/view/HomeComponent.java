package view;

import db.UserService;
import logic.User;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

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
        game.setCursor(new Cursor(Cursor.HAND_CURSOR));
        game.setFont(new Font("arial", Font.BOLD, 17));
        game.setBounds(387, 430, 70, 40);
        game.addActionListener(e -> {
            String balance = JOptionPane.showInputDialog("Balance");
            try{
                long b = Long.parseLong(balance);
                Map<String, String> params = new HashMap<>();
                params.put("balance", balance);
                params.put("create-game", "true");
                router.navigate("game-roulette", params);
            }catch (Exception e1) {
                if(balance != null) JOptionPane.showMessageDialog(null,
                        "Invalid Amount");
            }
        });

        record = new JButton("See History");
        record.setCursor(new Cursor(Cursor.HAND_CURSOR));
        record.setBounds(487, 430, 130, 40);
        record.setFont(new Font("arial", Font.BOLD, 17));
        record.setEnabled(false);
        record.addActionListener(e -> {
            router.navigate("history");
        });

        auth = new JButton("SignIn");
        auth.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        signUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signUp.setBounds(1080, 25, 80, 30);
        signUp.addActionListener(e->{
            showSignUpDialog();
        });

        nickName = new JLabel("");//RouletteGame.user.getNickName();
        nickName.setForeground(Color.WHITE);
        nickName.setFont(new Font("arial", Font.BOLD, 15));
        nickName.setBounds(980, 25, 130, 30);

        update();
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
            record.setEnabled(true);
        }else {
            nickName.setText("");
            auth.setText("SignIn");
            auth.setLocation(1080, 60);
            add(auth);
            add(signUp);
            record.setEnabled(false);
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
        BiConsumer<String, String> run = (nickN, pass) -> {
            try{
                User newUser = new User(nickN, pass);
                userService.insert(newUser);
                RouletteGame.user.setNickname(nickN);
                RouletteGame.user.setPassword(pass);
                int id = userService.selectID(nickN, pass);
                RouletteGame.user.setId(id);
                JOptionPane.showMessageDialog(null, "Welcome " + nickN);
                update();
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "User already exist 🫣" + e.getMessage());
            }
        };
        genericDialog(run, "User Registration");
    }

    public void genericDialog(BiConsumer<String, String> run, String title) {
        JTextField usernameField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 15, 5));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(null, panel, title,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String nickN = usernameField.getText().trim();
            String pass = passwordField.getText().trim();
            run.accept(nickN, pass);
        }
    }

    public void showSignUpDialog () {
        BiConsumer<String, String> run = (nickN, pass) -> {
            try{
                int id = userService.selectID(nickN, pass);
                RouletteGame.user.setId(id);
                RouletteGame.user.setNickname(nickN);
                RouletteGame.user.setPassword(pass);

                JOptionPane.showMessageDialog(null, "Welcome " + nickN);
                update();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Nickname or password " + "incorrect");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        };
        genericDialog(run, "SignUp");
    }

    public void logout() {
        RouletteGame.user.setId(-1);
        RouletteGame.user.setPassword(null);
        RouletteGame.user.setNickname(null);
    }
}
