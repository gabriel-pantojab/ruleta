package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class StreetRange extends RangeBet{

    public StreetRange(int amount, int valueInit, int valueFinal) throws Exception{
        super(amount, valueInit, valueFinal);
        if(valueInit+2 != valueFinal) throw new Exception("Invalid Range");
    }
}
