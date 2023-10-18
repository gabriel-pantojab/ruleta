package logic;

import java.awt.*;

/**
 * @author Gabriel Pantoja Bustamante - Esther Romero Aguilar
 */
public enum ValueColor {
    RED(204, 25, 31), BLACK(0, 0, 0), GREEN(34, 117, 76);
    private int r, g, b;
    private ValueColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public Color getColor() {
        return new Color(r, g, b);
    }
}
