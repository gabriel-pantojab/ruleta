package logic;
/**
 * @author Gabriel Pantoja Bustamante
 * **/
public class AngleSet extends SetBet{
    public AngleSet(int amount, int[] values) throws Exception {
        super(8, amount, values);
        if(values.length != 4)
            throw new Exception("Invalid Range");
    }
}
