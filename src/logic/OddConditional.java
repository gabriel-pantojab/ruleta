package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class OddConditional extends ConditionalBet{

    public OddConditional(int amount){
        super(amount, v -> v%2 != 0 );
    }
}
