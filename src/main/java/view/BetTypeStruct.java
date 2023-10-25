package view;

import java.util.ArrayList;

public class BetTypeStruct {
    private TypeBet type;
    private int[] values;

    public BetTypeStruct(TypeBet type, int[] values) {
        this.type = type;
        this.values = values;
    }

    public BetTypeStruct(TypeBet type) {
        this.type = type;
        this.values = null;
    }

    public TypeBet getType() {
        return type;
    }

    public int[] getValues() {
        return values;
    }

    public void setType(TypeBet type) {
        this.type = type;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
}
