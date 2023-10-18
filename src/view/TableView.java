package view;

import logic.BettingGrid;
import logic.BettingGridBox;
import logic.Chip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TableView extends JPanel implements MouseListener {
    private BettingGrid grid;
    private ArrayList<BettingGridBoxView> boxes;
    public TableView() {
        setLayout(null);
        setBackground(new Color(2, 76, 20));
        boxes = new ArrayList<BettingGridBoxView>();
        grid = new BettingGrid();
        buildBoxes();
        addMouseListener(this);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void buildBoxes() {
        for(int i = 0; i < grid.getGrid().length; i++) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                BettingGridBox b = grid.getGrid()[i][j];
                BettingGridBoxView b2 =
                        new BettingGridBoxView(j*Constants.WIDTH_GRID_BOX + 300,
                                i*Constants.HEIGHT_GRID_BOX + 100,
                                Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                                b.getValue()+"", b.getColor().getColor());
                boxes.add(b2);
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(BettingGridBoxView b : boxes) b.paint((Graphics2D)g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for(BettingGridBoxView b : boxes) {
            if(b.contains(x, y)) {
                b.setLastChip(new ChipView(Chip.FIVE, Color.BLUE));
                b.getLastChip().setX(b.getX() + 6);
                b.getLastChip().setY(b.getY() + 13);
            }
            if(b.clickBorder(x, y)) System.out.println("Border");
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
