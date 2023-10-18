package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    @Test
    public void betRedColor() throws Exception {
        game = new Game(2500L);
        Bet bet = new RedColor(Chip.FIVE_HUNDRED);
        game.toBetInRound(bet);
        Pocket pocket = new Pocket(0,21, ValueColor.RED);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () ->  assertEquals(1000, winAmount),
                () -> assertEquals(3000, game.getBalance())
        );
    }

    @Test
    public void streetBet() throws Exception{
        game = new Game(2500L);
        Bet bet = new StreetRange(Chip.HUNDRED, 1, 3);
        Pocket pocket = new Pocket(0, 2, ValueColor.BLACK);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(1200, winAmount),
                () -> assertEquals(3600, game.getBalance())
        );
    }

    @Test
    public void betEvenAndRedColor() throws Exception {
        game = new Game(2500L);
        Bet bet1 = new RedColor(Chip.FIVE_HUNDRED);
        Bet bet2 = new EvenConditional(Chip.FIVE_HUNDRED);
        game.toBetInRound(bet1);
        game.toBetInRound(bet2);
        Pocket pocket = new Pocket(0,8, ValueColor.BLACK);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () ->  assertEquals(1000, winAmount),
                () -> assertEquals(2500, game.getBalance())
        );
    }

    @Test
    public void uniqueBet() throws Exception{
        game = new Game(2500L);
        Bet bet = new UniqueBet(Chip.FIVE_HUNDRED, 9);
        Pocket pocket = new Pocket(0, 9, ValueColor.RED);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(18000, winAmount),
                () -> assertEquals(20000, game.getBalance())
        );
    }

    @Test
    public void dealerWins() throws Exception{
        game = new Game(2500L);
        Bet bet = new UniqueBet(Chip.FIVE_HUNDRED, 9);
        Pocket pocket = new Pocket(0, 10, ValueColor.RED);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(0, winAmount),
                () -> assertEquals(2000, game.getBalance())
        );
    }

    @Test
    public void firstColumnBet() throws Exception{
        game = new Game(2500L);
        Bet bet = new FirstColumnSet(Chip.FIVE_HUNDRED);
        Pocket pocket = new Pocket(0, 22, ValueColor.BLACK);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(1500, winAmount),
                () -> assertEquals(3500, game.getBalance())
        );
    }

    @Test
    public void secondDozenBet() throws Exception{
        game = new Game(2500L);
        Bet bet = new SecondDozenRange(Chip.FIVE_HUNDRED);
        Pocket pocket = new Pocket(0, 16, ValueColor.RED);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(1500, winAmount),
                () -> assertEquals(3500, game.getBalance())
        );
    }

    @Test
    public void firstSemesterBet() throws Exception{
        game = new Game(2500L);
        Bet bet = new FirstSemesterRange(Chip.FIVE_HUNDRED);
        Pocket pocket = new Pocket(0, 9, ValueColor.RED);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(1000, winAmount),
                () -> assertEquals(3000, game.getBalance())
        );
    }

    @Test
    public void adjacentBet() throws Exception{
        game = new Game(2500L);
        Bet bet = new AdjacentSet(Chip.FIVE_HUNDRED, new int[]{14, 17});
        Pocket pocket = new Pocket(0, 17, ValueColor.BLACK);
        game.toBetInRound(bet);
        long winAmount = game.getWinAmount(pocket);
        game.updateBalance(winAmount);
        assertAll(
                () -> assertEquals(9000, winAmount),
                () -> assertEquals(11000, game.getBalance())
        );
    }

    @Test
    public void errorInBalance() {
        assertThrows(Exception.class, ()->{
            game = new Game(1000000000001L);
        });
    }
}