package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LineBetStruct implements BuilderBetTypeStruct{
    private Set<Integer> topLine, bottomLine;
    private BettingGridBoxView box1, box2;
    private ArrayList<Integer> values;
    private int x, y;
    public LineBetStruct(BettingGridBoxView box1, BettingGridBoxView box2
            , ArrayList<Integer> values, int x, int y) {
        this.box1 = box1;
        this.box2 = box2;
        this.values = values;
        this.x = x;
        this.y = y;
        topLine = new HashSet<>(Arrays.asList(3, 6, 9, 12, 15, 18, 21, 24, 27
                , 30, 33, 36));
        bottomLine = new HashSet<>(Arrays.asList(1, 4, 7, 10, 13, 16, 19, 22,
                25, 28, 31, 34));
    }
    @Override
    public BetTypeStruct getBetStruct() {
        if((box1.clickBottomRight(x, y) && box2.clickBottomLeft(x,
                y) && bottomLine.contains(Integer.parseInt(box1.getValue().trim())) &&
                bottomLine.contains(Integer.parseInt(box2.getValue().trim()))
        ) ||
                (box1.clickTopRight(x, y) && box2.clickTopLeft(x, y) &&
                        topLine.contains(Integer.parseInt(box1.getValue().trim())) &&
                        topLine.contains(Integer.parseInt(box2.getValue().trim())))
        ) {
            int init, end;
            if (values.get(0) % 3 == 0) {
                init = values.get(0) - 2;
                end = values.get(1);
            } else {
                init = values.get(0);
                end = values.get(1) + 2;
            }
            return new BetTypeStruct(TypeBet.LINE, new int[]{init, end});
        }
        return null;
    }
}
