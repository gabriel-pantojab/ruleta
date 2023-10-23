package logic;

public class User {
    private String nickname;
    private String password;
    private int id;

    public User(String nickname, String password){
        this.nickname = nickname;
        this.password = password;
        this.id = -1;
    }

    public User() {
        this.nickname = null;
        this.password = null;
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

