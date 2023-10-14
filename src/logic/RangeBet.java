package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class RangeBet extends Bet {

    public RangeBet(int amount, int valueInit, int valueFinal){
        super(1, amount, new RangeRule(valueInit, valueFinal));
    }
}
