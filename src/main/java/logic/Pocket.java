package logic;

/**
 * @author Gabriel Pantoja Bustamante
 */

public class Pocket extends ElementRoulette {
    public Pocket(int position, int value, ValueColor color) {
        super(color, value);
        this.value = value;
        this.color = color;
    }
}
