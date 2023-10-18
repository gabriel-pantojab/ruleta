package logic;

import java.util.ArrayList;

/**
 * @author Esther Romero Aguilar
 * */

public class BettingGridBox {

    private ArrayList<Chip> chips;
    private int value;
    private ValueColor color;

    public BettingGridBox(ValueColor color, int value) {
        this.color = color;
        this.value = value;
        chips = new ArrayList<Chip>();
    }

    public void setColor(ValueColor color) {
        this.color = color;
    }

    public ValueColor getColor() {

        return color;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public void setChips(ArrayList<Chip> chips) {
        this.chips = chips;
    }

    public void addChip(Chip chip){
        chips.add(chip);
    }
}
