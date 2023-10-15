package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class ColorBet extends Bet{

    public ColorBet(Chip chips, ValueColor color){
        super(1, chips, new ColorRule(color));
    }
}
