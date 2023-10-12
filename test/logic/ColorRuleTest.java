package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorRuleTest {
    ColorRule rule;

    @BeforeEach
    public void setUp() {
        rule = new ColorRule(ValueColor.RED);
    }

    @Test
    public void valueColorEquals() {
        Pocket pocket = new Pocket(0, 0, ValueColor.RED);
        assertTrue(rule.valid(pocket));
    }

    @Test
    public void valueColorDistinct() {
        Pocket pocket = new Pocket(0, 0, ValueColor.BLACK);
        Pocket pocket1 = new Pocket(0, 0, ValueColor.GREEN);
        assertAll(
                () -> assertFalse(rule.valid(pocket)),
                () -> assertFalse(rule.valid(pocket))
        );
    }
}