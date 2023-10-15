package logic;
/**
 * @author Esther Romero Aguilar - Gabriel Pantoja Bustamante
 * */

public abstract class SetBet extends Bet{

    public SetBet(int amount, int[] values){
        super(1, amount, new SetRule(values));
    }
}
