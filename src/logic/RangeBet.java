package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class RangeBet extends Bet {
    protected int initValue;
    protected int endValue;

    public RangeBet(int bonus, Chip chip, int initValue, int endValue){
        super(bonus, chip, new RangeRule(initValue, endValue));
        this.initValue = initValue;
        this.endValue = endValue;
    }

    public int getEndValue() {
        return endValue;
    }

    public int getInitValue() {
        return initValue;
    }

    public void setEndValue(int endValue) {
        this.endValue = endValue;
    }

    public void setInitValue(int initValue) {
        this.initValue = initValue;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if (o instanceof RangeBet other) {
            return other.initValue == this.initValue && other.endValue == this.endValue;
        }
        return false;
    }
}
