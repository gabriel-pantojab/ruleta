package logic;

public class RangeBet extends Bet {

    public RangeBet(int amount, int valueInit, int valueFinal){
        super(1, amount, new RangeRule(valueInit, valueFinal));
    }

    public boolean validRangeBet(Pocket pocket){
        return rule.valid(pocket);
    }

}
