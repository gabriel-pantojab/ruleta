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
        pocket = new Pocket(0, 13, ValueColor.RED);
    }

    @Test
    public void newRound(){

    }
}