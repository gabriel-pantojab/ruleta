package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class EvenConditional extends ConditionalBet{
    public EvenConditional(int amount){
        super(amount, v -> v%2 == 0);
    }
}
