package view;

import java.awt.*;

public class BetBox extends BoxElement{
    private String value;
    public BetBox(int x, int y, int width, int height, String value) {
        super(x, y, width, height, new Color(3, 51, 6));
        this.value = value;
    }

    public BetBox(int x, int y, int width, int height, String value, Color color) {
        super(x, y, width, height, color);
        this.value = value;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 26));
        g.drawString(value, x + width / 6, y + height / 2 + 9);
        BasicStroke wideStroke = new BasicStroke(4.0f);
        g.setStroke(wideStroke);
        g.drawRect(x, y, width, height);
        super.paint(g);
        if(lastChip != null) {
            lastChip.paint(g);
        }
    }
}
