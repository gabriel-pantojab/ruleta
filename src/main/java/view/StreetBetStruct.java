package view;

import java.util.ArrayList;

public class StreetBetStruct implements BuilderBetTypeStruct{
    private BettingGridBoxView box1;
    private int x, y;
    private ArrayList<Integer> values;
    public StreetBetStruct(BettingGridBoxView box1, ArrayList<Integer> values
            , int x, int y) {
        this.box1 = box1;
        this.values = values;
        this.x = x;
        this.y = y;
    }
    @Override
    public BetTypeStruct getBetStruct() {
        if(box1.clickBottomBorder(x, y) || box1.clickTopBorder(x, y)) {
            int init, end;
            if(values.get(0) % 3 == 0) {
                init = values.get(0) - 2;
                end = values.get(0);
            }else {
                init = values.get(0);
                end = values.get(0) + 2;
            }
            return new BetTypeStruct(TypeBet.STREET, new int[]{init, end});
        }
        return null;
    }
}
