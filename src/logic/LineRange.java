package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class LineRange extends RangeBet{

    public LineRange(Chip chips, int valueInit, int valueFinal) throws Exception{
        super(5, chips, valueInit, valueFinal);
        if(valueInit+5 != valueFinal) throw new Exception("Invalid Range");
    }
}
