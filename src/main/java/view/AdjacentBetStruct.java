package view;

import java.util.ArrayList;

public class AdjacentBetStruct implements BuilderBetTypeStruct{
    private BettingGridBoxView box1, box2;
    private ArrayList<Integer> values;
    private int x, y;
    public AdjacentBetStruct(BettingGridBoxView box1, BettingGridBoxView box2
            , ArrayList<Integer> values, int x, int y) {
        this.box1 = box1;
        this.box2 = box2;
        this.values = values;
        this.x = x;
        this.y = y;
    }
    @Override
    public BetTypeStruct getBetStruct() {
        if(box1.clickRightBorder(x, y) && box2.clickLeftBorder(x, y) ||
                box1.clickBottomBorder(x, y) && box2.clickTopBorder(x, y)
        ) {
            return new BetTypeStruct(TypeBet.ADJACENT, new int[]{values.get(0),
                    values.get(1)});
        }
        return null;
    }
}
