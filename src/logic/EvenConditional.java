package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class EvenConditional extends ConditionalBet{
    public EvenConditional(int amount){
        super(amount, v -> v%2 == 0);
    }

    @Override
    public boolean validConditionalBet(Pocket pocket) {
        int value = pocket.getValue();
        return condition.apply(value);
    }
}
