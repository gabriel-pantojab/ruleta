package logic;
/**
 * @author Esther Romero Aguilar - Gabriel Pantoja Bustamante
 * */

public abstract class SetBet extends Bet{

    public SetBet(int bonus, Chip chip, int[] values){
        super(bonus, chip, new SetRule(values));
    }
}
