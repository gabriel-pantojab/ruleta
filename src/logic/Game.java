package logic;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private long balance;
    private Stack<Pocket> rounds;
    private Round currentRound;
    private Roulette roulette;
    private BettingGrid bettingGrid;
    private ArrayList<Chip> chips;

    public Game (long balance) throws Exception {
        rounds = new Stack<Pocket>();
        this.balance = balance;
        if(balance > 1000000000000L) throw new Exception("The amount must be less than one billon");
    }

    public void createNewRound(){
    }

    public void subtractBalance(int amount){
    }

    public void updateBalance(){}

    public Pocket spinRoulette(){
        return null;
    }

    public boolean toBetInRound(){
        return false;
    }

    public void updateChips(){}

    public long getWinAmount(Pocket pocket){
        return 0;
    }
}
