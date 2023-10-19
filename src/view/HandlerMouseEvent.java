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
        table.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        table.setLocationCurrentChip(x, y);
        table.repaint();
    }
}
