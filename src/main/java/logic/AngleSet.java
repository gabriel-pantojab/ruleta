package logic;
/**
 * @author Gabriel Pantoja Bustamante
 * **/
public class AngleSet extends SetBet{
    public AngleSet(Chip chip, int[] values) throws Exception {
        super(8, chip, values);
        if(values.length != 4)
            throw new Exception("Invalid Range");
    }
}
