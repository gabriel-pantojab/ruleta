package view;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HomeComponent extends JPanel {
    private JButton game;
    private JButton record;
    private Router router;
    private JButton auth;
    private JButton signUp;
    private JLabel nickName;


    public HomeComponent() {
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

        String texgAuth = RouletteGame.user ? "Logout" : "SignIn";
        auth = new JButton(texgAuth);
        auth.addActionListener(e -> {
            if(!RouletteGame.user) {
                showRegistrationDialog();
            }else {
                //salir
                JOptionPane.showMessageDialog(null, "Thanks, come back soon");
                auth.setText("SigIn");
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
        if(RouletteGame.user) add(nickName);
        if(!RouletteGame.user) add(signUp);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondoImage = Toolkit.getDefaultToolkit().getImage(
                "./src/assets/fondo2.jpg");
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
                JOptionPane.showMessageDialog(null, "Welcome " + usernameField.getText());
                //actualizar user
                RouletteGame.user = true;
                auth.setText("Logout");
                nickName.setText("Name");//RouletteGame.user.getNickName()
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "User already exist 🫣");
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
                //guardar en db
                JOptionPane.showMessageDialog(null, "Welcome " + usernameField.getText());
                //actualizar user
                RouletteGame.user = true;
                auth.setText("Logout");
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nickname or password " +
                        "incorrect" +
                        " 🫣");
            }
        }
    }
}
