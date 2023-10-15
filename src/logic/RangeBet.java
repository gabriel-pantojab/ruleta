package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class RangeBet extends Bet {

    public RangeBet(int amount, int valueInit, int valueFinal){
        super(1, amount, new RangeRule(valueInit, valueFinal));
    }
}
