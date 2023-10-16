package logic;

public class Game {
    private long balance;
    private Round[] rounds;
    private Round currentRound;

    public Game (long balance) throws Exception {
        this.balance = balance;
        if(balance > 1000000000) throw new Exception("The amount must be less than one billon");
    }
    public void createRound(){
        Round round = new Round();
        currentRound = round;
        // comenzar ronda
        // int res = correntRound.calculeWinAmount(pocket);
        // subtractBalance(res);
    }

    public void subtractBalance(int amount){
        balance -= amount;
    }
}
