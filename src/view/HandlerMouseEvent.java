package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HandlerMouseEvent extends MouseAdapter {
    private TableView table;
    public HandlerMouseEvent(TableView table) {
        this.table = table;
        this.table.addMouseListener(this);
        this.table.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        table.toBet(x, y);
        for(ChipView c : table.getChipsAvailable()) {
            if(c.contains(x, y)) {
                table.setCurrentChip((ChipView) c.clone());
                table.getCurrentChip().setRadio(17);
                table.getCurrentChip().setFontSize(10);
            }
        }
        table.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if(table.getCurrentChip() != null) {
            for(BettingGridBoxView b : table.getBoxes()) {
                b.setSelect(b.contains(x, y) || b.clickBorder(x, y));
            }
            table.setLocationCurrentChip(x, y);
        }
        table.repaint();
    }
}
