package view;

import java.util.ArrayList;

public class AngleBetStruct implements BuilderBetTypeStruct{
    private ArrayList<Integer> values;
    public AngleBetStruct(ArrayList<Integer> values) {
        this.values = values;
    }
    @Override
    public BetTypeStruct getBetStruct() {
        return new BetTypeStruct(TypeBet.ANGLE, new int[]{
                values.get(0),
                values.get(1),
                values.get(2),
                values.get(3),
        });
    }
}
