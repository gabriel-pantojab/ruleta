package logic;

/**
 * @author Gabriel Pantoja Bustamante
 * **/

import java.util.function.Function;

public class ConditionalRule implements RuleBet{

    private final Function<Pocket, Boolean> condition;

    public ConditionalRule(Function<Pocket, Boolean> condition) {
        this.condition = condition;
    }
    @Override
    public boolean valid(Pocket pocket) {
        return condition.apply(pocket);
    }
}
