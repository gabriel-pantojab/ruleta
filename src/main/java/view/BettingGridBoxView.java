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
        g.fillOval(x+3, y+4, width-6, height-8);
        g.setColor(Color.WHITE);
        BasicStroke wideStroke = new BasicStroke(4.0f);
        g.setStroke(wideStroke);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString(value, x + 7, y + height/2 + 12);
        super.paint(g);
        if(lastChip != null) {
            lastChip.paint(g);
        }
    }
}
