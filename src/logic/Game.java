package logic;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private long balance;
    private Stack<Round> rounds;
    private Round currentRound;
    private Roulette roulette;
    private BettingGrid bettingGrid;
    private ArrayList<Chip> chipsAvailable;

    private final Chip[] orderedChips;
    public Game (long balance) throws Exception {
        if(balance > 1000000000000L) throw new Exception("The amount must be less than one billon");
        rounds = new Stack<Round>();
        roulette = new Roulette();
        this.balance = balance;
        chipsAvailable = new ArrayList<Chip>();
        orderedChips = new Chip[]{
                Chip.ONE,
                Chip.FIVE,
                Chip.TEN,
                Chip.FIFTY,
                Chip.HUNDRED,
                Chip.TEN_THOUSAND,
                Chip.HUNDRED_THOUSAND,
                Chip.ONE_MILLION,
                Chip.TEN_MILLION,
                Chip.HUNDRED_MILLION,
                Chip.ONE_BILLION
        };
        createChipsAvailable(balance);
    }

    private void createChipsAvailable(long balance) {
        for (Chip chip : orderedChips) {
            if (chip.getValue() <= balance) {
                chipsAvailable.add(chip);
            }
        }
    }

    public void createNewRound(){
        rounds.push(new Round());
        currentRound = rounds.peek();
    }

    public void updateBalance(long winAmount) {
        balance += winAmount;
        updateChips();
    }

    public void subtractBalance(long amount){
        balance -= amount;
    }

    public Pocket spinRoulette(){
        roulette.spin();
        return roulette.getCurrentPocket();
    }

    public boolean toBetInRound(Bet bet){
        boolean success = false;
        long amount = 0;
        for(Chip c : bet.getChips()) {
            amount += c.getValue();
        }
        if(amount <= balance) {
            currentRound.toBet(bet);
            subtractBalance(amount);
            updateChips();
            success = true;
        }
        return success;
    }

    private void updateChips() {
        int index = chipsAvailable.size() - 1;
        Chip max = chipsAvailable.get(index);
        if(max.getValue() <= balance) {
            for(int i = index + 1; i < orderedChips.length; i++) {
                if (orderedChips[i].getValue() <= balance) {
                    chipsAvailable.add(orderedChips[i]);
                }
            }
        }else {
            chipsAvailable.remove(index);
        }
    }

    public long getWinAmount(Pocket pocket){
        return currentRound.calculateWinAmount(pocket);
    }

    public ArrayList<Chip> getChipsAvailable() {
        return  chipsAvailable;
    }
}
