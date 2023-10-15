package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class RangeBet extends Bet {

    public RangeBet(int bonus, Chip chip, int valueInit, int valueFinal){
        super(bonus, chip, new RangeRule(valueInit, valueFinal));
    }
}
