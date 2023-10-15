package logic;

import java.util.ArrayList;

/**
 * @author Esther Romero Aguilar
 * */

public abstract class Bet {
    protected RuleBet rule;

    protected final int bonus;
    protected ArrayList<Chip> chips;

    public Bet(int bonus, Chip chip, RuleBet rule){
        this.rule = rule;
        this.bonus = bonus;
        this.chips = new ArrayList<Chip>();
        this.chips.add(chip);
    }

    public ArrayList<Chip> getChips() {
        return chips;
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public int getBonus() {
        return bonus;
    }

    public RuleBet getRule() {
        return rule;
    }

    public boolean validRule(Pocket pocket) {
        return rule.valid(pocket);
    }
}
