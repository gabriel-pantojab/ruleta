package logic;

import java.util.function.Function;

public class ConditionalRule implements RuleBet{

    private final Function<Integer, Boolean> condition;

    public ConditionalRule(Function<Integer, Boolean> condition) {
        this.condition = condition;
    }
    @Override
    public boolean valid(Pocket pocket) {
        int value = pocket.getValue();
        return condition.apply(value);
    }
}
