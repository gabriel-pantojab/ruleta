package logic;

public abstract class Bet {
    protected int bonus;
    protected int amount;

    protected RuleBet rule;
    public Bet(int amount, int bonus, RuleBet rule) {
        this.amount = amount;
        this.bonus = bonus;
    }

    public int getAmount() {
        return amount;
    }

    public int getBonus() {
        return bonus;
    }
}
