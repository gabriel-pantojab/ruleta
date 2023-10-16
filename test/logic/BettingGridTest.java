package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BettingGridTest {
    BettingGrid bettingGrid;
    @BeforeEach
    public void setUp() {
        bettingGrid = new BettingGrid();
    }

    @Test
    public void putChipInZero() {
        bettingGrid.putChip(0, Chip.FIVE);
        int s = bettingGrid.getGrid()[0][0].getChips().size();
        assertEquals(1, s);
    }

    @Test
    public void putChipInThirtySix() {
        bettingGrid.putChip(36, Chip.FIVE);
        int s = bettingGrid.getGrid()[0][0].getChips().size();
        assertEquals(1, s);
    }
}