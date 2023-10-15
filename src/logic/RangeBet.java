package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class RangeBet extends Bet {

    public RangeBet(int bonus, Chip chips, int valueInit, int valueFinal){
        super(bonus, chips, new RangeRule(valueInit, valueFinal));
    }
}
