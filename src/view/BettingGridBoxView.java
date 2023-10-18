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
    private ChipView lastChip;

    public BettingGridBoxView(int x, int y, int width, int height,
                              String value, Color color) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        lastChip = null;
    }

    public String getValue() {
        return value;
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
        if(lastChip != null) {
            lastChip.paint(g);
        }
    }

    public boolean contains(int x, int y) {
        Rectangle r = new Rectangle(this.x + 3, this.y + 3, width - 4,
                height - 4);
        return r.contains(x, y);
    }

    public boolean clickBorder(int x, int y) {
        boolean up = x >= this.x && x <= this.x + width && (y >= this.y - 2 && y
                <= this.y + 1);
        boolean down =
                x >= this.x && x <= this.x + width && (y >= this.y + height - 2  && y
                <= this.y + height + 1);
        boolean left =
                y >= this.y && y <= this.y + height && x >= this.x - 2 && x <= this.x + 1;
        boolean right =
                y >= this.y && y <= this.y + height && x >= this.x + width - 2 && x <= this.x + width + 1;
        return up || down || left || right;
    }

    public ChipView getLastChip() {
        return lastChip;
    }

    public void setLastChip(ChipView chip) {
        lastChip = chip;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
