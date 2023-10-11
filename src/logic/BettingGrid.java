package logic;

public class BettingGrid {
    private BettingGridBox[][] grid;

    public BettingGrid() {
        grid = new BettingGridBox[5][14];
        initializeGrid();
    }

    private void initializeGrid() {
        String[] type = {"0", "3", "6", "9", "12", "15", "18", "21", "24", "27", "30", "33", "36", "3RD",
                     "vacio", "2", "5", "8", "11", "14", "17", "20", "23", "26", "29", "32", "35", "2RD",
                        "00", "1", "4", "7", "10", "13", "16", "19", "22", "25", "28", "31", "34", "1RD",
                   "vacio", "1-12", "1-12", "1-12", "1-12", "13-24", "13-24", "13-24", "13-24", "25-36", "25-36", "25-36", "25-36", "vacio",
                       "vacio", "1-18", "1-18", "even", "even", "rojo", "rojo", "negro", "negro", "odd", "odd", "19-36", "19-36", "vacio"};

        String[] colores = {"s/color", "rojo", "negro", "rojo", "rojo", "negro", "rojo", "rojo", "negro", "rojo", "rojo", "negro", "rojo", "s/color",
                       "vacio", "negro", "rojo", "negro", "negro", "rojo", "negro", "negro", "rojo", "negro", "negro", "rojo", "negro", "s/color",
                       "s/color", "rojo", "negro", "rojo", "negro", "negro", "rojo", "rojo", "negro", "rojo", "negro", "negro", "rojo", "s/color",
                       "vacio", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "s/color", "vacio",
                       "vacio", "s/color", "s/color", "s/color", "s/color", "rojo", "rojo", "negro", "negro", "s/color", "s/color", "s/color", "s/color", "vacio"};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 14; j++) {
                int index = (i * 14) + j;
                if (index < type.length) {
                    grid[i][j] = new BettingGridBox(type[index], colores[index]);
                } else {
                    grid[i][j] = null;
                }
            }
        }
    }

    public BettingGridBox[][] getGrid() {
        return grid;
    }
}
