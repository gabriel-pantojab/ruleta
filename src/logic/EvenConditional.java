package logic;

import java.util.function.Function;

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
