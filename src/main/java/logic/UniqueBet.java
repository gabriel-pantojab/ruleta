package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class UniqueBet extends Bet{
    private int value;
    public UniqueBet(Chip chip, int value){
        super(35, chip, new UniqueRule(value));
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if (o instanceof UniqueBet other) {
            return other.value == this.value;
        }
        return false;
    }
}
