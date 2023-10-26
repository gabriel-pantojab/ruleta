package logic;

import java.util.ArrayList;

/**
 * @author Esther Romero Aguilar
 * */

public class BettingGridBox extends ElementRoulette {
    private ArrayList<Chip> chips;

    public BettingGridBox(ValueColor color, int value) {
        super(color, value);
        chips = new ArrayList<Chip>();
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
