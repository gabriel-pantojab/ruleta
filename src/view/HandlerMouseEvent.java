package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HandlerMouseEvent extends MouseAdapter {
    private TableView table;
    public HandlerMouseEvent(TableView table) {
        this.table = table;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        table.repaint();
    }
}
