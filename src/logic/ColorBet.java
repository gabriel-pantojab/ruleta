package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class ColorBet extends Bet{
    protected ValueColor color;
    public ColorBet(Chip chip, ValueColor color){
        super(1, chip, new ColorRule(color));
        this.color = color;
    }

    public ValueColor getColor() {
        return color;
    }

    public void setColor(ValueColor color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if (o instanceof ColorBet other) {
            return other.color == this.color;
        }
        return false;
    }
}
