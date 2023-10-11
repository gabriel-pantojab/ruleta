package logic;

/**
 * @author Esther Romero Aguilar
 * */

public class BettingGridBox {

    private int num;
    private ValueColor color;
    private int value;

    public BettingGridBox(int num, ValueColor color, int value) {
        this.num = num;
        this.color = color;
        this.value = value;
    }

    public void setColor(ValueColor color) {
        this.color = color;
    }

    public ValueColor getColor() {

        return color;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
