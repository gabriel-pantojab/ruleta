package logic;
/**
 * @author Gabriel Pantoja Bustamante
 * **/

public class AdjacentSet extends SetBet{
    public AdjacentSet(Chip chip, int[] values) throws Exception {
        super(17, chip, values);
        if(values.length != 2)
            throw new Exception("Invalid Range");
    }
}
