package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class ColorBet extends Bet{

    public ColorBet(int amount, ValueColor color){
        super(1, amount, new ColorRule(color));
    }
}
