package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class OddConditional extends ConditionalBet{

    public OddConditional(int amount){
        super(amount, v -> v%2 != 0 );
    }

    @Override
    public boolean validConditionalBet(Pocket pocket) {
        int value = pocket.getValue();
        return condition.apply(value);
    }
}
