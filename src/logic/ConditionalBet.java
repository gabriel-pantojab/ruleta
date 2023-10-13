package logic;
/**
 * @author Esther Romero Aguilar
 * */

import java.util.function.Function;

public abstract class ConditionalBet extends Bet {
    protected Function<Pocket, Boolean> condition;
    public ConditionalBet(int amount, Function<Pocket, Boolean> condition){
        super(1,amount, new ConditionalRule(condition));
    }

    public abstract boolean validConditionalBet(Pocket pocket);
}
