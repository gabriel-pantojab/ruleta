package logic;

public class ColorBet extends Bet{

    public ColorBet(int amount, ValueColor color){
        super(1, amount, new ColorRule(color));
    }

    public boolean validColorBet(Pocket pocket){
        return rule.valid(pocket);
    }
}
