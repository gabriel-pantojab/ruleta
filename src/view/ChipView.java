package view;

import logic.Chip;

import java.awt.*;

public class ChipView {
    private int x, y;
    private final String value;
    private Chip chip;
    private int radio;
    private Color color;
    public ChipView(Chip chip) {
        x = 0;
        y = 0;
        radio = 17;
        this.chip = chip;
        this.value = getValueText(chip);
        updateColor(chip);
    }

    public String getValueText(Chip c) {
        String ans = "";
        switch (c)  {
            case ONE -> ans = "1";
            case FIVE -> ans = "5";
            case TEN -> ans = "10";
            case FIFTY -> ans = "50";
            case HUNDRED -> ans = "100";
            case FIVE_HUNDRED -> ans = "500";
            case ONE_THOUSAND -> ans = "1K";
            case TEN_THOUSAND -> ans = "10K";
            case HUNDRED_THOUSAND -> ans = "100K";
            case ONE_MILLION -> ans = "1M";
            case TEN_MILLION -> ans = "10M";
            case HUNDRED_MILLION -> ans = "100M";
            case ONE_BILLION -> ans = "1B";
            default -> ans = "";
        }
        return ans;
    }

    private void updateColor(Chip c) {
        switch (c) {
            case ONE -> color = new Color(50, 130, 246);
            case FIVE -> color = new Color(117, 250, 141);
            case TEN -> color = new Color(240, 81, 99);
            case FIFTY -> color = new Color(119, 67, 66);
            case HUNDRED -> color = new Color(125, 62, 245);
            case FIVE_HUNDRED -> color = new Color(255, 253, 85);
            case ONE_THOUSAND -> color = new Color(218, 95, 247);
            case TEN_THOUSAND -> color = new Color(91, 247, 226);
            case HUNDRED_THOUSAND -> color = new Color(127, 130, 187);
            case ONE_MILLION -> color = new Color(55, 126, 71);
            case TEN_MILLION -> color = new Color(129, 128, 73);
            case HUNDRED_MILLION -> color = new Color(240, 134, 80);
            case ONE_BILLION -> color = new Color(128, 128, 128);
            default -> color = Color.BLUE;
        }
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
        ChipView c = new ChipView(chip);
        c.setRadio(this.radio);
        c.setLocation(x, y);
        return c;
    }

    public boolean contains(int x, int y) {
        Rectangle r = new Rectangle(this.x+radio/2, this.y+radio/2, radio,
                radio);
        return r.contains(x, y);
    }
 }
