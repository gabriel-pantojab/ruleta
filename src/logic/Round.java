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
}
