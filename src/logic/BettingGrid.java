package logic;

/**
 * @author Esther Romero Aguilar
 * */

public class BettingGrid {
    private BettingGridBox[][] grid;

    public BettingGrid() {
        grid = new BettingGridBox[3][13];
        initializeGrid();
    }

    private void initializeGrid() {
        int[] type = {0,3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36,
                      0,2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35,
                      0,1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};

        ValueColor[] colors = {
                ValueColor.GREEN, ValueColor.RED, ValueColor.BLACK, ValueColor.RED, ValueColor.RED,
                ValueColor.BLACK, ValueColor.RED, ValueColor.RED, ValueColor.BLACK, ValueColor.RED,
                ValueColor.RED, ValueColor.BLACK, ValueColor.RED, ValueColor.GREEN, ValueColor.BLACK,
                ValueColor.RED, ValueColor.BLACK, ValueColor.BLACK, ValueColor.RED, ValueColor.BLACK,
                ValueColor.BLACK, ValueColor.RED, ValueColor.BLACK, ValueColor.BLACK, ValueColor.RED,
                ValueColor.BLACK, ValueColor.GREEN, ValueColor.RED, ValueColor.BLACK, ValueColor.RED,
                ValueColor.BLACK, ValueColor.BLACK, ValueColor.RED, ValueColor.RED, ValueColor.BLACK,
                ValueColor.RED, ValueColor.BLACK, ValueColor.BLACK, ValueColor.RED
        };

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 13; j++) {
                int index = (i * 13) + j;
                grid[i][j] = new BettingGridBox(colors[index], type[index]);
            }
        }
    }

    public BettingGridBox[][] getGrid() {
        return grid;
    }

    public void setGrid(BettingGridBox[][] grid) {
        this.grid = grid;
    }

    public void putChip(int value, Chip chip){
        if(value == 0){
            grid[0][0].addChip(chip);
            grid[0][1].addChip(chip);
            grid[0][2].addChip(chip);
        }else{
            int column = (int)(Math.ceil(value/3.0));
            int row = value % 3 == 0 ? 2 : value % 3 - 1;
            grid[row][column].addChip(chip);
        }
    }
}
