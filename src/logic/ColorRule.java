package logic;

/**
 * @author Gabriel Pantoja Bustamante
 * **/
public class ColorRule implements RuleBet{

    private final ValueColor color;

    public ColorRule(ValueColor color) {
        this.color = color;
    }
    @Override
    public boolean valid(Pocket pocket) {
        ValueColor color = pocket.getColor();
        return this.color == color;
    }

    public ValueColor getColor() {
        return color;
    }
}
