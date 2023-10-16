package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    private Round round;
    private Pocket pocket;

    @BeforeEach
    public void setUp(){
        round = new Round();
    }

    @Test
    public void redColorBet(){
        pocket = new Pocket(0, 36, ValueColor.RED);
        Bet b1 = new RedColor(Chip.TEN);
        Bet b2 = new RedColor(Chip.TEN);
        Bet b3 = new RedColor(Chip.TEN);
        round.toBet(b1);
        round.toBet(b2);
        round.toBet(b3);
        long result = round.calculateWinAmount(pocket);
        assertEquals(60, result);
    }

    @Test
    public void evenBet() {
        pocket = new Pocket(0, 8, ValueColor.BLACK);
        Bet bet1 = new EvenConditional(Chip.HUNDRED);
        round.toBet(bet1);
        long result = round.calculateWinAmount(pocket);
        assertEquals(200, result);
    }

    @Test
    public void firstColumnAndSecondDozen() {
        pocket = new Pocket(0, 26, ValueColor.BLACK);
        Bet b1 = new FirstColumnSet(Chip.HUNDRED);
        Bet b2 = new SecondDozenRange(Chip.HUNDRED);
        round.toBet(b1);
        round.toBet(b2);
        long result = round.calculateWinAmount(pocket);
        assertEquals(0, result);
    }
}