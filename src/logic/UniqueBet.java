package logic;

public class UniqueBet extends Bet{
    public UniqueBet(int amount, int value){
        super(1, amount, new UniqueRule(value));
    }

    public boolean validUniqueBet(Pocket pocket){
        return rule.valid(pocket);
    }
}
