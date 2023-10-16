package logic;

import java.util.ArrayList;

public class Round {
    private ArrayList<Bet> bets;
    private long totalBet;

    public Round() {
        bets = new ArrayList<Bet>();
        totalBet = 0;
    }

    public void toBet(Bet bet) {
        int index = existBet(bet);
        if(index != -1) {
            for(Chip c : bet.getChips()) {
                bets.get(index).addChip(c);
                totalBet += c.getValue();
            }
        }else {
            bets.add(bet);
            for(Chip c : bet.getChips()) {
                totalBet += c.getValue();
            }
        }
    }

    private int existBet(Bet bet) {
        return bets.indexOf(bet);
    }

    public long calculateWinAmount(Pocket pocket) {
        long winAmount = 0;
        for(Bet bet : bets) {
            if(bet.validRule(pocket)) {
                long amount = bet.getAmount();
                winAmount += amount + bet.getBonus() * amount;
            }
        }
        return winAmount;
    }

    public void setBets(ArrayList<Bet> bets) {
        this.bets = bets;
    }

    public void setTotalBet(long totalBet) {
        this.totalBet = totalBet;
    }

    public ArrayList<Bet> getBets() {
        return bets;
    }

    public long getTotalBet() {
        return totalBet;
    }

    @Override
    public Object clone() {
        ArrayList<Bet> newBets = new ArrayList<Bet>(bets);
        Round newRound = new Round();
        newRound.setBets(newBets);
        newRound.setTotalBet(totalBet);
        return newRound;
    }
}
