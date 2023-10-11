package logic;

public class Pocket {
    private int position;
    private String color;
    private int value;

    public Pocket(int position, int value, String color) {
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

    public String getColor() {
        return color;
    }
}
