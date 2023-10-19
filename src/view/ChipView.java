package view;

import logic.Chip;

import java.awt.*;

public class ChipView {
    private int x, y;
    private final String value;
    private Chip chip;
    private int radio;
    private Color color;
    public ChipView(Chip chip, Color color) {
        x = 0;
        y = 0;
        radio = 17;
        this.chip = chip;
        this.value = chip.getValue() + "";
        this.color = color;
    }

    public void paint(Graphics2D g) {
        BasicStroke wideStroke = new BasicStroke(1.0f);
        g.setStroke(wideStroke);
        g.setColor(color);
        g.fillOval(x, y, 2 * radio, 2 * radio);
        g.setColor(Color.WHITE);
        g.fillOval(x + radio/2, y + radio/2, radio, radio);
        g.drawOval(x, y, 2*radio, 2*radio);
        g.setColor(Color.BLACK);
        g.setFont(new Font("arial", Font.PLAIN, 17));
        g.drawString(value, x + radio / 2 + 4, y + 23);
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone() {
        ChipView c = new ChipView(chip, new Color(color.getRGB()));
        c.setLocation(x, y);
        return c;
    }

    public boolean contains(int x, int y) {
        Rectangle r = new Rectangle(x+radio/2, y+radio/2, radio, radio);
        return r.contains(x, y);
    }
 }
