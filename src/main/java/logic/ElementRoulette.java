package logic;

public abstract class ElementRoulette {
    protected ValueColor color;
    protected int value;

    public ElementRoulette(ValueColor color, int value) {
        this.color = color;
        this.value =  value;
    }

    public void setColor(ValueColor color) {
        this.color = color;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ValueColor getColor() {
        return color;
    }
}
