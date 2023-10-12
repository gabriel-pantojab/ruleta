package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class SetBet extends Bet{

    public SetBet(int amount, int[] values){
        super(1, amount, new SetRule(values));
    }

    public boolean validSetBet(Pocket pocket){
        return rule.valid(pocket);
    }
}
