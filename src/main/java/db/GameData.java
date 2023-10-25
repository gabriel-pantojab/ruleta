package db;

public class GameData {
    private String balance;
    private String totalWinAmount;
    private String totalLostAmount;

    public GameData(String balance, String totalLostAmount,
                    String totalWinAmount) {
        this.balance = balance;
        this.totalLostAmount = totalLostAmount;
        this.totalWinAmount = totalWinAmount;
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
