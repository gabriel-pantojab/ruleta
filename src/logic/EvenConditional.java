package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class EvenConditional extends ConditionalBet{
    public EvenConditional(Chip chip){
        super(chip, v -> {
            int value = v.getValue();
            return value % 2 == 0;
        });
    }
}
