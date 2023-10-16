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
        pocket = new Pocket(0, 15, ValueColor.BLACK);
        Bet b1 = new FirstColumnSet(Chip.HUNDRED);
        Bet b2 = new SecondDozenRange(Chip.HUNDRED);
        round.toBet(b1);
        round.toBet(b2);
        long result = round.calculateWinAmount(pocket);
        assertEquals(300, result);
    }

    @Test
    public void redColorAndOdd() {
        pocket = new Pocket(0, 29, ValueColor.BLACK);
        Bet b1 = new RedColor(Chip.HUNDRED);
        Bet b2 = new OddConditional(Chip.HUNDRED);
        round.toBet(b1);
        round.toBet(b2);
        long result = round.calculateWinAmount(pocket);
        assertEquals(200, result);
    }

    @Test
    public void streetOneToThree() {
        pocket = new Pocket(0, 1, ValueColor.RED);
        try{
            Bet b1 = new StreetRange(Chip.HUNDRED, 1, 3);
            round.toBet(b1);
            long result = round.calculateWinAmount(pocket);
            assertEquals(1200, result);
        }catch (Exception e) {

        }
    }

    @Test
    public void lineFourToSeven() {
        pocket = new Pocket(0, 9, ValueColor.RED);
        try{
            Bet b1 = new LineRange(Chip.HUNDRED, 4, 9);
            round.toBet(b1);
            long result = round.calculateWinAmount(pocket);
            assertEquals(600, result);
        }catch (Exception e) {

        }
    }

    @Test
    public void angle() {
        pocket = new Pocket(0, 8, ValueColor.BLACK);
        try{
            Bet b1 = new AngleSet(Chip.HUNDRED, new int[]{8, 9, 11, 12});
            round.toBet(b1);
            long result = round.calculateWinAmount(pocket);
            assertEquals(900, result);
        }catch (Exception e) {

        }
    }

    @Test
    public void allValues() {
        pocket = new Pocket(0, 15, ValueColor.BLACK);
        for(int i = 0; i < 36; i++) {
            round.toBet(new UniqueBet(Chip.ONE, i + 1));
        }
        long result = round.calculateWinAmount(pocket);
        assertEquals(36, result);
    }

    @Test
    public void unique() {
        pocket = new Pocket(0, 1, ValueColor.RED);

        Bet b1 = new UniqueBet(Chip.HUNDRED, 1);
        round.toBet(b1);
        long result = round.calculateWinAmount(pocket);
        assertEquals(3600, result);
    }
}