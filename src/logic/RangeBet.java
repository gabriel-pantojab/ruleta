package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class RangeBet extends Bet {

    public RangeBet(int bonus, int amount, int valueInit, int valueFinal){
        super(bonus, amount, new RangeRule(valueInit, valueFinal));
    }
}
