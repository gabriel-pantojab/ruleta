package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBetTest {
    private UniqueRule rule;

    @BeforeEach
    public void setUp() {
        rule = new UniqueRule(10);
    }

    @Test
    public void valueEquals() {
        Pocket pocket = new Pocket(0, 10, ValueColor.RED);
        assertTrue(rule.valid(pocket));
    }

    @Test
    public void valueDistinct() {
        Pocket pocket = new Pocket(0, 25, ValueColor.RED);
        assertFalse(rule.valid(pocket));
    }
}