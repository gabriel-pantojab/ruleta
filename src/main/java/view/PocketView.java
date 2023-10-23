package view;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class PocketView {
    private int centerX, centerY;
    private double angleRotation;
    private int width, height;
    private Color color;
    private String value;

    public PocketView(int cX, int cY, int width, int height, double angleR, Color color, String value) {
        centerX = cX;
        centerY = cY;
        this.width = width;
        this.height = height;
        angleRotation = angleR;
        this.color = color;
        this.value = value;
    }

    public void paint(Graphics2D g) {
        g.setColor(color);
        AffineTransform rotation = AffineTransform.getRotateInstance(Math.toRadians(angleRotation), centerX, centerY);
        g.setTransform(rotation);
        int[] xs = {centerX - width / 2, centerX + width / 2, centerX + width / 2 - width / 5, centerX - width / 2 + width / 5};
        int[] ys = {centerY - height / 2, centerY - height / 2, centerY + height / 2, centerY + height / 2};

        g.fillPolygon(xs, ys, 4);
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.BOLD, 15));
        g.drawString(value, centerX- 7, centerY);
        g.setTransform(new AffineTransform());
    }

    public void update(int x, int y, double angle, Color color){
        centerX = x;
        centerY = y;
        angleRotation = angle;
        color = color;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public double getAngleRotation() {
        return angleRotation;
    }

    public Color getColor() {
        return color;
    }
}
