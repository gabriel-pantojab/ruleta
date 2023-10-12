package logic;

public abstract class Bet {
    protected int bonus;
    protected int amount;
    public Bet(int amount, int bonus) {
        this.amount = amount;
        this.bonus = bonus;
    }
}
