package db;

public class GameData {
    private String balance;
    private String currentBalance;
    private String totalWinAmount;
    private String totalLostAmount;
    private int idGame;

    public GameData(String balance, String currentBalance, String totalLostAmount,
                    String totalWinAmount, int idGame) {
        this.idGame = idGame;
        this.balance = balance;
        this.currentBalance = currentBalance;
        this.totalLostAmount = totalLostAmount;
        this.totalWinAmount = totalWinAmount;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public String getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getBalance() {
        return balance;
    }

    public String getTotalLostAmount() {
        return totalLostAmount;
    }

    public String getTotalWinAmount() {
        return totalWinAmount;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setTotalLostAmount(String totalLostAmount) {
        this.totalLostAmount = totalLostAmount;
    }

    public void setTotalWinAmount(String totalWinAmount) {
        this.totalWinAmount = totalWinAmount;
    }

    public String toString() {
        return balance + " " + totalWinAmount + " " + totalLostAmount;
    }
}
