package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class OddConditional extends ConditionalBet{

    public OddConditional(int amount){
        super(amount, v -> {
            int value = v.getValue();
            return value % 2 != 0;
        } );
    }
}
