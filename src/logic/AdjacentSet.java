package logic;

public class AdjacentSet extends SetBet{
    public AdjacentSet(int amount, int[] values) throws Exception {
        super(amount, values);
        if(values.length != 2)
            throw new Exception("Invalid Range");
    }
}
