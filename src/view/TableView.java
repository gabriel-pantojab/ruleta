package view;

import logic.BettingGrid;
import logic.BettingGridBox;
import logic.Chip;
import logic.ValueColor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TableView extends JPanel {
    private BettingGrid grid;
    private ArrayList<BoxElement> boxes;
    private ChipView currentChip;
    private int indexCurrentChip;
    private ArrayList<ChipView> chipsAvailable;

    private RouletteView roulette;
    private ArrayList<ChipView> chipsInBoxes;
    private ArrayList<BetBox> betBoxes;
    private JButton home;

    public TableView(BettingGrid grid) {
        Router router = Router.getInstance();
        setLayout(null);
        setBackground(new Color(3, 51, 6));
        home = new JButton("Home");
        home.setBounds(1105, 10, 70, 30);
        home.addActionListener(e -> router.navigate("home"));
        boxes = new ArrayList<BoxElement>();
        betBoxes = new ArrayList<BetBox>();
        buildBetBoxes();
        this.grid = grid;
        buildBoxes();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        currentChip = null;
        chipsAvailable = new ArrayList<ChipView>();
        chipsInBoxes = new ArrayList<ChipView>();
        indexCurrentChip = -1;
        roulette = new RouletteView();
        add(roulette);
        add(home);
    }

    private void buildBetBoxes() {
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX, 278, Constants.WIDTH_GRID_BOX * 4, 50, " 1-12"));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 4, 278, Constants.WIDTH_GRID_BOX * 4, 50, "13-24"));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 8, 278, Constants.WIDTH_GRID_BOX * 4, 50, "25-36"));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX, 328, Constants.WIDTH_GRID_BOX * 2, 50, " 1-18"));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 2, 328, Constants.WIDTH_GRID_BOX * 2, 50, "EVEN"));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 4, 328, Constants.WIDTH_GRID_BOX * 2, 50, "", ValueColor.RED.getColor()));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 6, 328, Constants.WIDTH_GRID_BOX * 2, 50, "", ValueColor.BLACK.getColor()));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 8, 328, Constants.WIDTH_GRID_BOX * 2, 50, "ODD"));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 10, 328, Constants.WIDTH_GRID_BOX * 2, 50, "19-36"));
    }

    public ArrayList<BetBox> getBetBoxes() {
        return betBoxes;
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
                BettingGridBoxView b2 = getBettingGridBoxView(i, j);
                boxes.add(b2);
            }
            String text = " " + (3 - i) + "°";
            boxes.add(new BetBox(grid.getGrid()[i].length * Constants.WIDTH_GRID_BOX + 450, i * Constants.HEIGHT_GRID_BOX + 100, Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX, text));
        }
    }

    private BettingGridBoxView getBettingGridBoxView(int i, int j) {
        BettingGridBox b = grid.getGrid()[i][j];
        String value = b.getValue() + "";
        int n = value.length();
        String spaces = n < 2 ? " " : "";
        return new BettingGridBoxView(j *Constants.WIDTH_GRID_BOX + 450,
                        i *Constants.HEIGHT_GRID_BOX + 100,
                        Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                        spaces + value, b.getColor().getColor());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BoxElement b : boxes) b.paint((Graphics2D) g);
        for(BetBox b : betBoxes) b.paint((Graphics2D) g);
        for(ChipView c : chipsInBoxes) c.paint((Graphics2D) g);
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
        for(BoxElement b : boxes) {
            if(b.contains(x, y)) {
                b.setLastChip((ChipView) currentChip.clone());
                b.getLastChip().setActive(true);
                b.getLastChip().setRadio(17);
                b.getLastChip().setLocation(b.getX() + 6, b.getY() + 13);
                ans = true;
                break;
            }else if(b.clickBorder(x, y)) {
                ChipView c = (ChipView) currentChip.clone();
                c.setActive(true);
                chipsInBoxes.add(c);
                ans = true;
            }
        }
        for(BetBox b : betBoxes) {
            if(b.contains(x, y)) {
                b.setLastChip((ChipView) currentChip.clone());
                b.getLastChip().setActive(true);
                b.getLastChip().setRadio(17);
                b.getLastChip().setLocation(b.getX() + b.getWidth() / 2 - 8,
                        b.getY() + 7);
                ans = true;
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

    public ArrayList<BoxElement> getBoxes() {
        return boxes;
    }
}
