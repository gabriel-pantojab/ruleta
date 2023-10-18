package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class BettingGridBoxView {
    private int x;
    private int y;
    private int width;
    private int height;
    private String value;
    private Color color;

    public BettingGridBoxView(int x, int y, int width, int height,
                              String value, Color color) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x+3, y+4, width-6, height-8);
        g.setColor(Color.WHITE);
        BasicStroke wideStroke = new BasicStroke(2.0f);
        g.setStroke(wideStroke);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString(value, x + 7, y + height/2 + 12);
    }
}
