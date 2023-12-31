package logic;

/**
 * @author Gabriel Pantoja Bustamante
 */
public class Roulette {
    private Pocket[] pockets;
    private Pocket currentPocket;
    public Roulette() {
        buildRouletteValues();
        currentPocket = pockets[0];
    }

    private void buildRouletteValues() {
        int[] values = {0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26};
        pockets = new Pocket[values.length];
        pockets[0] = new Pocket(0, 0, ValueColor.GREEN);
        for(int i = 1; i < values.length; i++) {
            ValueColor color = i % 2 == 0 ? ValueColor.BLACK : ValueColor.RED;
            pockets[i] = new Pocket(i, values[i], color);
        }
    }

    public Pocket[] getPockets() {
        return pockets;
    }

    public void spin() {
        int random = (int)(Math.random() * pockets.length);
        currentPocket = pockets[random];
    }

    public Pocket getCurrentPocket() {
        return currentPocket;
    }

    public void setCurrentPocket(Pocket currentPocket) {
        this.currentPocket = currentPocket;
    }

    public void setPockets(Pocket[] pockets) {
        this.pockets = pockets;
    }
}
