package logic;
/**
 * @author Esther Romero Aguilar
 * */

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class ConditionalBet extends Bet {
    protected Function<Pocket, Boolean> condition;
    public ConditionalBet(Chip chip, Function<Pocket, Boolean> condition){
        super(1,chip, new ConditionalRule(condition));
    }

    @Override
    public boolean validRule(Pocket pocket) {
        return  condition.apply(pocket);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if (o instanceof ConditionalBet other) {
            Pocket p = new Pocket(0, 22, ValueColor.RED);
            return other.condition.apply(p).equals(this.condition.apply(p));
        }
        return false;
    }
}
