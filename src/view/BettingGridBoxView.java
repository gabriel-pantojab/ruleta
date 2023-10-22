package view;

import java.awt.*;

public class BettingGridBoxView extends BoxElement {
    private String value;

    public BettingGridBoxView(int x, int y, int width, int height,
                              String value, Color color) {
        super(x, y, width, height, color);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x+5, y+6, width-9, height-11);
        g.setColor(Color.WHITE);
        BasicStroke wideStroke = new BasicStroke(6.0f);
        g.setStroke(wideStroke);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("arial", Font.BOLD, 25));
        g.drawString(value, x + 9, y + height/2 + 12);
        super.paint(g);
        if(lastChip != null) {
            lastChip.paint(g);
        }
    }
}
