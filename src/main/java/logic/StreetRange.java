package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class StreetRange extends RangeBet{

    public StreetRange(Chip chip, int valueInit, int valueFinal) throws Exception{
        super(11, chip, valueInit, valueFinal);
        if(valueInit+2 != valueFinal) throw new Exception("Invalid Range");
    }
}
