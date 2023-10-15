package logic;
/**
 * @author Esther Romero Aguilar
 * */

public class LineRange extends RangeBet{

    public LineRange(Chip chip, int valueInit, int valueFinal) throws Exception{
        super(5, chip, valueInit, valueFinal);
        if(valueInit+5 != valueFinal) throw new Exception("Invalid Range");
    }
}
