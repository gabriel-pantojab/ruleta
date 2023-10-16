package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class OddConditional extends ConditionalBet{

    public OddConditional(Chip chip){
        super(chip, v -> {
            int value = v.getValue();
            return value % 2 != 0;
        } );
    }
}
