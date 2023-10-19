package view;

import logic.BettingGrid;
import logic.BettingGridBox;
import logic.Chip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableView extends JPanel {
    private BettingGrid grid;
    private ArrayList<BettingGridBoxView> boxes;
    private ChipView currentChip;
    private int indexCurrentChip;
    private ArrayList<ChipView> chipsAvailable;

    private RouletteView roulette;

    public TableView(BettingGrid grid) {
        setLayout(null);
        setBackground(new Color(3, 51, 6));
        boxes = new ArrayList<BettingGridBoxView>();
        this.grid = grid;
        buildBoxes();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        currentChip = null;
        chipsAvailable = new ArrayList<ChipView>();
        indexCurrentChip = -1;
        roulette = new RouletteView();
        add(roulette);
    }

    public void setCurrentChip(ChipView currentChip) {
        this.currentChip = currentChip;
    }

    public ChipView getCurrentChip() {
        return currentChip;
    }

    public void setIndexCurrentChip(int indexCurrentChip) {
        this.indexCurrentChip = indexCurrentChip;
    }

    private void buildBoxes() {
        for(int i = 0; i < grid.getGrid().length; i++) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                BettingGridBox b = grid.getGrid()[i][j];
                String value = b.getValue() + "";
                int n = value.length();
                String spaces = n < 2 ? " " : "";
                BettingGridBoxView b2 =
                        new BettingGridBoxView(j*Constants.WIDTH_GRID_BOX + 400,
                                i*Constants.HEIGHT_GRID_BOX + 100,
                                Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                                spaces + value, b.getColor().getColor());
                boxes.add(b2);
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BettingGridBoxView b : boxes) b.paint((Graphics2D) g);
        if(currentChip != null) currentChip.paint((Graphics2D) g);
        g.setColor(new Color(66, 66, 66));
        g.fillRect(0, 463, 1200, 100);
        for (ChipView c : chipsAvailable) {
            c.setActive(chipsAvailable.indexOf(c) == indexCurrentChip);
            c.paint((Graphics2D) g);
        }
    }

    public boolean toBet(int x, int y) {
        boolean ans = false;
        if(currentChip == null) return false;
        for(BettingGridBoxView b : boxes) {
            if(b.contains(x, y)) {
                b.setLastChip((ChipView) currentChip.clone());
                b.getLastChip().setActive(true);
                b.getLastChip().setRadio(17);
                b.getLastChip().setLocation(b.getX() + 6, b.getY() + 13);
                ans = true;
                break;
            }
        }
        return ans;
    }

    public void setLocationCurrentChip(int x, int y) {
        currentChip.setLocation(x - currentChip.getRadio(), y - currentChip.getRadio());
    }

    public void updateChipsAvailable(ArrayList<Chip> chips) {
        chipsAvailable.clear();
        int x = 20, y = 480;
        int radio = 30;
        for(Chip c : chips) {
            ChipView cV = new ChipView(c, 16);
            cV.setRadio(radio);
            cV.setLocation(x, y);
            x += 2*radio + 10;
            chipsAvailable.add(cV);
        }
        repaint();
    }

    public ArrayList<ChipView> getChipsAvailable() {
        return chipsAvailable;
    }

    public ArrayList<BettingGridBoxView> getBoxes() {
        return boxes;
    }
}
