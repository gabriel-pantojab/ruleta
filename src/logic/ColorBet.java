package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class ColorBet extends Bet{

    public ColorBet(Chip chip, ValueColor color){
        super(1, chip, new ColorRule(color));
    }
}
