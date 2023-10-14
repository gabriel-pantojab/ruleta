package logic;
/**
 * @author Esther Romero Aguilar
 * */

import java.util.function.Function;

public abstract class ConditionalBet extends Bet {
    protected Function<Integer, Boolean> condition;
    public ConditionalBet(int amount, Function<Integer, Boolean> condition){
        super(1,amount, new ConditionalRule(condition));
    }

    @Override
    public boolean validRule(Pocket pocket) {
        int value = pocket.getValue();
        return  condition.apply(value);
    }
}
