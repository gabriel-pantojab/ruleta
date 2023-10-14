package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class UniqueBet extends Bet{
    public UniqueBet(int amount, int value){
        super(1, amount, new UniqueRule(value));
    }
}
