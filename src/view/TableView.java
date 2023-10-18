package view;

import logic.BettingGrid;
import logic.BettingGridBox;

import javax.swing.*;
import java.awt.*;

public class TableView extends JPanel {
    private BettingGrid grid;
    public TableView() {
        setLayout(null);
        setBackground(new Color(2, 76, 20));
        grid = new BettingGrid();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i = 0; i < grid.getGrid().length; i++) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                BettingGridBox b = grid.getGrid()[i][j];
                BettingGridBoxView b2 =
                        new BettingGridBoxView(j*Constants.WIDTH_GRID_BOX + 300,
                                i*Constants.HEIGHT_GRID_BOX + 100,
                                Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                                b.getValue()+"", b.getColor().getColor());
                b2.paint((Graphics2D) g);
            }
        }
    }
}
