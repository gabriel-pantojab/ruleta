package logic;
/**
 * @author Esther Romero Aguilar
 * */

public abstract class Bet {
    protected RuleBet rule;

    protected final int bonus;
    protected final int amount;

    public Bet(int bonus, int amount, RuleBet rule){
        this.rule = rule;
        this.bonus = bonus;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getBonus() {
        return bonus;
    }

    public RuleBet getRule() {
        return rule;
    }
}
