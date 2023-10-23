package view;

import java.util.ArrayList;

public class BetTypeStruct {
    private String type;
    private int[] values;

    public BetTypeStruct(String type, int[] values) {
        this.type = type;
        this.values = values;
    }

    public BetTypeStruct(String type) {
        this.type = type;
        this.values = null;
    }

    public String getType() {
        return type;
    }

    public int[] getValues() {
        return values;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValues(int[] values) {
        this.values = values;
    }
}
