package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class UniqueBet extends Bet{
    public UniqueBet(Chip chip, int value){
        super(35, chip, new UniqueRule(value));
    }
}
