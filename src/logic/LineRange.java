package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class LineRange extends RangeBet{

    public LineRange(int amount, int valueInit, int valueFinal) throws Exception{
        super(amount, valueInit, valueFinal);
        if(valueInit+5 != valueFinal) throw new Exception("Invalid Range");
    }
}
