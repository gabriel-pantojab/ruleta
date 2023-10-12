package logic;

/**
 * @author Gabriel Pantoja Bustamante
 * **/

import java.util.HashSet;

public class SetRule implements RuleBet{

    private final HashSet<Integer> set;

    public SetRule(int[] values) {
        set = new HashSet<Integer>();
        buildSet(values);
    }

    private void buildSet(int[] values) {
        for (int value : values) {
            set.add(value);
        }
    }
    @Override
    public boolean valid(Pocket pocket) {
        int value = pocket.getValue();
        return set.contains(value);
    }

    public HashSet<Integer> getSet() {
        return set;
    }
}
