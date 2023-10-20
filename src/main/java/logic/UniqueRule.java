package logic;

/**
 * @author Gabriel Pantoja Bustamante
 * **/

public class UniqueRule implements RuleBet{
    private final int value;

    public UniqueRule(int value) {
        this.value = value;
    }
    @Override
    public boolean valid(Pocket pocket) {
        int value = pocket.getValue();
        return this.value == value;
    }

    public int getValue() {
        return value;
    }
}
