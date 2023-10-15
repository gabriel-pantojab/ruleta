package logic;

public class AngleSet extends SetBet{
    public AngleSet(int amount, int[] values) throws Exception {
        super(amount, values);
        if(values.length != 4)
            throw new Exception("Invalid Range");
    }
}
