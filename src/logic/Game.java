package logic;

import java.util.ArrayList;

public class Game {
    private long balance;
    private ArrayList<Round> rounds;
    private Round currentRound;
    private Roulette roulette;
    private BettingGrid bettingGrid;
    private ArrayList<Chip> chips;

    public Game (long balance) throws Exception {
        this.balance = balance;
        if(balance > 1000000000000L) throw new Exception("The amount must be less than one billon");
    }

    public void createNewRound(){
    }

    public void subtractBalance(int amount){
    }

    public void updateBalance(){}

    public void startRound(){}

    public boolean toBetInRound(){
        return false;
    }

    public void updateChips(){}


}
