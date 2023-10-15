package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class StreetRange extends RangeBet{

    public StreetRange(Chip chips, int valueInit, int valueFinal) throws Exception{
        super(11, chips, valueInit, valueFinal);
        if(valueInit+2 != valueFinal) throw new Exception("Invalid Range");
    }
}
