package logic;
/**
 * @author Esther Romero Aguilar - Gabriel Pantoja Bustamante
 * */

public abstract class SetBet extends Bet{

    public SetBet(int bonus, int amount, int[] values){
        super(bonus, amount, new SetRule(values));
    }
}
