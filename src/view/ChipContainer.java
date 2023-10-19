package view;

import logic.Chip;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChipContainer extends JPanel {
    private TableView table;
    private ArrayList<ChipView> chips;
    public ChipContainer(TableView table) {
        setBackground(new Color(77, 77, 77));
        this.table = table;
        chips = new ArrayList<ChipView>();
    }

    public void updateChips(ArrayList<Chip> chips) {
        this.chips.clear();
        int x = 10, y = 20;
        int radio = 30;
        for(Chip c : chips) {
            ChipView cV = new ChipView(c, Color.BLUE);
            cV.setRadio(radio);
            cV.setLocation(x, y);
            x += 2*radio + 10;
            this.chips.add(cV);
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(ChipView c : chips) c.paint((Graphics2D) g);
    }
}
