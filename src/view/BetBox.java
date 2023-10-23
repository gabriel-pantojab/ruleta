package view;

import logic.Bet;
import logic.Chip;

import java.awt.*;
import java.lang.reflect.Constructor;

public class BetBox extends BoxElement{
    private String value;
    private Class<? extends Bet> bet;
    public BetBox(int x, int y, int width, int height, String value,
                  Class<? extends Bet> bet) {
        super(x, y, width, height, new Color(3, 51, 6));
        this.value = value;
        this.bet = bet;
    }

    public BetBox(int x, int y, int width, int height, String value,
                  Color color, Class<? extends Bet> bet) {
        super(x, y, width, height, color);
        this.value = value;
        this.bet = bet;
    }

    public Bet getBet(Chip chip) {
        Bet b = null;
        try {
            Constructor<? extends Bet> c = bet.getConstructor(Chip.class);
            b = c.newInstance(chip);
        }catch (Exception ignored) {
        }
        return  b;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 26));
        g.drawString(value, x + width / 6, y + height / 2 + 9);
        BasicStroke wideStroke = new BasicStroke(6.0f);
        g.setStroke(wideStroke);
        g.drawRect(x, y, width, height);
        super.paint(g);
        if(lastChip != null) {
            lastChip.paint(g);
        }
    }
}
