package logic;

import java.util.Set;

/**
 * @author Esther Romero Aguilar - Gabriel Pantoja Bustamante
 * */

public abstract class SetBet extends Bet{
    protected Set<Integer> set;
    public SetBet(int bonus, Chip chip, int[] values){
        super(bonus, chip, new SetRule(values));
        buildSet(values);
    }

    private void buildSet(int[] values) {
        for(int value : values) {
            set.add(value);
        }
    }

    public Set<Integer> getSet() {
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if (o instanceof SetBet other) {
            return other.set.equals(this.set);
        }
        return false;
    }
}
