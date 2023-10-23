package view;

import java.awt.*;

public class BoxElement {
    protected int x, y;
    protected int width, height;
    protected Color color;
    protected boolean select;
    protected ChipView lastChip;

    public BoxElement(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.select = false;
        this.lastChip = null;
    }

    public void setLastChip(ChipView lastChip) {
        this.lastChip = lastChip;
    }

    public ChipView getLastChip() {
        return lastChip;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean contains(int x, int y) {
        Rectangle r = new Rectangle(this.x + 6, this.y + 6, width - 12,
                height - 12);
        return r.contains(x, y);
    }

    public boolean clickBorder(int x, int y) {
        boolean up = clickTopBorder(x, y);
        boolean bottom = clickBottomBorder(x, y);
        boolean left = clickLeftBorder(x, y);
        boolean right = clickRightBorder(x, y);
        return up || bottom || left || right;
    }

    public boolean clickTopBorder(int x, int y) {
        return x >= this.x && x <= this.x + width && (y >= this.y - 6 && y
                <= this.y + 6);
    }

    public boolean clickBottomBorder(int x, int  y) {
        return x >= this.x && x <= this.x + width && (y >= this.y + height - 6  && y
                <= this.y + height + 6);
    }

    public boolean clickLeftBorder(int x, int  y) {
        return y >= this.y + 26 && y <= this.y + height - 26 && x >= this.x - 6 && x <= this.x + 6;
    }

    public boolean clickRightBorder(int x, int y) {
        return y >= this.y + 26 && y <= this.y + height - 26 && x >= this.x + width - 6 && x <= this.x + width + 6;
    }

    public void paint(Graphics2D g) {
        if(select) {
            g.setColor(new Color(145, 255, 189, 150));
            g.fillRect(x, y, width, height);
        }
    }
}