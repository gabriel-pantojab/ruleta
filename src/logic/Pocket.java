package logic;

/**
 * @author Gabriel Pantoja Bustamante
 */

public class Pocket {
    private int position;
    private ValueColor color;
    private int value;

    public Pocket(int position, int value, ValueColor color) {
        this.position = position;
        this.value = value;
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public ValueColor getColor() {
        return color;
    }

    public void setColor(ValueColor color) {
        this.color = color;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
