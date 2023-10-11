/**
 * @author Esther Romero Aguilar
 * */

import logic.BettingGrid;
import logic.BettingGridBox;

public class Main {
    public static void main(String[] args) {
        BettingGrid bettingGrid = new BettingGrid();

        BettingGridBox[][] grid = bettingGrid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                BettingGridBox box = grid[i][j];
                if (box != null) {
                    System.out.print(box.getColor() + "\t");
                } else {
                    System.out.print("Vacío\t\t\t");
                }
            }
            System.out.println();
        }
    }
}