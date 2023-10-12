package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetBetTest {
    private SetRule rule;

    @BeforeEach
    public void setUp() {
        rule = new SetRule(new int[]{2, 3, 5, 6});
    }

    @Test
    public void valueContainsInSet() {
        Pocket pocket = new Pocket(0, 5, ValueColor.BLACK);
        assertTrue(rule.valid(pocket));
    }

    @Test
    public void valueNotContainsInSet() {
        Pocket pocket = new Pocket(0, 4, ValueColor.BLACK);
        assertFalse(rule.valid(pocket));
    }
}