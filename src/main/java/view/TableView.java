package view;

import logic.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class TableView extends JPanel {
    private BettingGrid grid;
    private ArrayList<BettingGridBoxView> boxes;
    private ChipView currentChip;
    private int indexCurrentChip;
    private ArrayList<ChipView> chipsAvailable;
    private RouletteView roulette;
    private ArrayList<ChipView> chipsInBoxes;
    private ArrayList<BetBox> betBoxes;

    private JButton spinButton;
    private JButton clearGridButton;
    private JLabel balanceLabel;
    private JLabel totalBetLabel;
    private JButton goHome;

    private Router router;

    public TableView(BettingGrid grid) {
        router = Router.getInstance();
        setLayout(null);
        setBackground(new Color(3, 51, 6));
        boxes = new ArrayList<BettingGridBoxView>();
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

        spinButton = new JButton("SPIN");
        spinButton.setBounds(400, 400, 70, 30);
        spinButton.setEnabled(false);

        clearGridButton = new JButton("Clear");
        clearGridButton.setBounds(500, 400, 70, 30);
        clearGridButton.setEnabled(false);

        balanceLabel = new JLabel("Balance: ");
        balanceLabel.setFont(new Font("arial", Font.BOLD, 20));
        balanceLabel.setBounds(400, 30, 300, 30);
        balanceLabel.setForeground(Color.WHITE);

        totalBetLabel = new JLabel("Total bet: 0");
        totalBetLabel.setFont(new Font("arial", Font.BOLD, 20));
        totalBetLabel.setBounds(750, 30, 300, 30);
        totalBetLabel.setForeground(Color.WHITE);

        goHome = new JButton("Home");
        goHome.setBounds(1100, 30, 70, 30);
        goHome.addActionListener(e->{
            Object[] options = {"Save and Exit", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "", "Casino",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if(choice == 0) {
                //guardar en la db
                JOptionPane.showMessageDialog(null, "Guardando...");
            }
            router.navigate("home");
        });

        add(roulette);
        add(spinButton);
        add(balanceLabel);
        add(totalBetLabel);
        add(clearGridButton);
        add(goHome);
    }

    private void buildBetBoxes() {
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX, 278,
                Constants.WIDTH_GRID_BOX * 4, 50, " 1-12", FirstDozenRange.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 4, 278, Constants.WIDTH_GRID_BOX * 4, 50, "13-24", SecondDozenRange.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 8, 278, Constants.WIDTH_GRID_BOX * 4, 50, "25-36", ThirdDozenRange.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX, 328,
                Constants.WIDTH_GRID_BOX * 2, 50, " 1-18", FirstSemesterRange.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 2, 328, Constants.WIDTH_GRID_BOX * 2, 50, "EVEN", EvenConditional.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 4, 328, Constants.WIDTH_GRID_BOX * 2, 50, "", ValueColor.RED.getColor(), RedColor.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 6, 328, Constants.WIDTH_GRID_BOX * 2, 50, "", ValueColor.BLACK.getColor(), BlackColor.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 8, 328, Constants.WIDTH_GRID_BOX * 2, 50, "ODD", OddConditional.class));
        betBoxes.add(new BetBox(450 + Constants.WIDTH_GRID_BOX + Constants.WIDTH_GRID_BOX * 10, 328, Constants.WIDTH_GRID_BOX * 2, 50, "19-36", SecondDozenRange.class));
        betBoxes.add(new BetBox(1061, 100,
                Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                " 3°", ThirdColumnSet.class));
        betBoxes.add(new BetBox(1061, 159,
                Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                " 2°", SecondColumnSet.class));
        betBoxes.add(new BetBox(1061, 218,
                Constants.WIDTH_GRID_BOX, Constants.HEIGHT_GRID_BOX,
                " 1°", FirstColumnSet.class));
    }

    public JButton getSpinButton() {
        return spinButton;
    }

    public JButton getClearGridButton() {
        return clearGridButton;
    }

    public void spinRoulette() {
        roulette.spin();
    }

    public void setBalanceLabel(String newBalance) {
        balanceLabel.setText("Balance: "+newBalance);
    }

    public void setTotalBetLabel(String total) {
        totalBetLabel.setText("Total bet: " + total);
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
        for(BettingGridBoxView b : boxes) b.paint((Graphics2D) g);
        for(BetBox b : betBoxes) b.paint((Graphics2D) g);
        for(ChipView c : chipsInBoxes) c.paint((Graphics2D) g);
        //if(currentChip != null) currentChip.paint((Graphics2D) g);
        g.setColor(new Color(66, 66, 66));
        g.fillRect(0, 463, 1200, 100);
        for (ChipView c : chipsAvailable) {
            c.setActive(chipsAvailable.indexOf(c) == indexCurrentChip);
            c.paint((Graphics2D) g);
        }
    }

    public void selectBoxes(ArrayList<Integer> indexs) {
        for(int v : indexs) {
            int ini, inc = 1;
            if(v % 3 == 0) {
                ini = v / 3;
            }else {
                ini = v == 1 ? 27 : 27 + (v - 1) / 3;
                inc = -1;
            }
            boxes.get(ini).setSelect(true);
            boxes.get(ini + inc*13).setSelect(true);
            boxes.get(ini + inc*26).setSelect(true);
        }
    }

    public BetTypeStruct getTypeBet(int x, int y) {
        int count = 0;
        boolean bottom = true, top = true;
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(BettingGridBoxView b : boxes) {
            if(b.clickBorder(x, y)) {
                count++;
                bottom &= b.clickBottomBorder(x, y);
                top &= b.clickTopBorder(x, y);
                values.add(Integer.parseInt(b.getValue().trim()));
            }
        }
        if(count == 4) {
            return new BetTypeStruct("angle", new int[]{
                    values.get(0),
                    values.get(1),
                    values.get(2),
                    values.get(3),
            });
        }else if(bottom || top){
            if(count == 2) {
                int init, end;
                if(values.get(0) % 3 == 0) {
                    init = values.get(0) - 2;
                    end = values.get(1);
                }else {
                    init = values.get(0);
                    end = values.get(1) + 2;
                }
                return new BetTypeStruct("line", new int[]{init, end});
            }else if(count == 1) {
                int init, end;
                if(values.get(0) % 3 == 0) {
                    init = values.get(0) - 2;
                    end = values.get(0);
                }else {
                    init = values.get(0);
                    end = values.get(0) + 2;
                }
                return new BetTypeStruct("street", new int[]{init, end});
            }
        }else if(count == 2) {
            return new BetTypeStruct("adjacent", new int[]{values.get(0),
                    values.get(1)});
        }
        return new BetTypeStruct("unique");
    }


    public Bet toBet(int x, int y) {
        Bet ans = null;
        if(currentChip == null) return null;
        for(BettingGridBoxView b : boxes) {
            if(b.contains(x, y)) {
                b.setLastChip((ChipView) currentChip.clone());
                b.getLastChip().setActive(true);
                b.getLastChip().setRadio(17);
                b.getLastChip().setLocation(b.getX() + 6, b.getY() + 13);
                ans = new UniqueBet(currentChip.getChip(),
                        Integer.parseInt(b.getValue().trim()));
            }else if(b.clickBorder(x, y)) {
                ChipView c = (ChipView) currentChip.clone();
                c.setActive(true);
                chipsInBoxes.add(c);
            }
        }
        if(ans == null) {
            BetTypeStruct betTypeStruct = getTypeBet(x, y);
            String type = betTypeStruct.getType();
            int[] values = betTypeStruct.getValues();
            try{
                ans = switch (type) {
                    case "street" ->
                            new StreetRange(currentChip.getChip(), values[0],
                                    values[1]);
                    case "line" ->
                            new LineRange(currentChip.getChip(), values[0],
                                    values[1]);
                    case "adjacent" ->
                            new AdjacentSet(currentChip.getChip(), values);
                    case "angle" -> new AngleSet(currentChip.getChip(), values);
                    default -> ans;
                };
            }catch (Exception ignored){}
        }


        for(BetBox b : betBoxes) {
            if(b.contains(x, y)) {
                b.setLastChip((ChipView) currentChip.clone());
                b.getLastChip().setActive(true);
                b.getLastChip().setRadio(17);
                b.getLastChip().setLocation(b.getX() + b.getWidth() / 2 - 8,
                        b.getY() + 7);
                ans = b.getBet(currentChip.getChip());
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

    public void clearGrid() {
        for(BettingGridBoxView b : boxes) {
            b.setLastChip(null);
        }
        for(BetBox b : betBoxes) {
            b.setLastChip(null);
        }
    }
}
