package logic;

public class RangeRule implements RuleBet{

    private final int minLimit;
    private final int maxLimit;

    public RangeRule(int minLimit, int maxLimit) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean valid(Pocket pocket) {
        int value = pocket.getValue();
        return value >= minLimit && value <= maxLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public int getMinLimit() {
        return minLimit;
    }
}
