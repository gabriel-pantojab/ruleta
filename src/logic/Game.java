package logic;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private long balance;
    private Stack<Round> rounds;
    private Round currentRound;
    private Roulette roulette;
    private BettingGrid bettingGrid;
    private ArrayList<Chip> chips;

    public Game (long balance) throws Exception {
        rounds = new Stack<Round>();
        roulette = new Roulette();
        this.balance = balance;
        if(balance > 1000000000000L) throw new Exception("The amount must be less than one billon");
    }

    public void createNewRound(){
        rounds.push(new Round());
        currentRound = rounds.peek();
    }

    public void subtractBalance(int amount){
        balance -= amount;
    }

    public void updateBalance(){
    }

    public Pocket spinRoulette(){
        roulette.spin();
        return roulette.getCurrentPocket();
    }

    public boolean toBetInRound(){
        return false;
    }

    public void updateChips(){}

    public long getWinAmount(Pocket pocket){
        return 0;
    }
}
