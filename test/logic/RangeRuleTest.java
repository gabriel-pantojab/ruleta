package logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeRuleTest {
    RangeRule rule;

    @Test
    public void valueBetweenOfRange() {
        rule = new RangeRule(1, 12);
        Pocket pocket = new Pocket(0, 5, ValueColor.BLACK);
        assertTrue(rule.valid(pocket));
    }

    @Test
    public void valueLessThanTheLowerLimit() {
        rule = new RangeRule(13, 24);
        Pocket pocket = new Pocket(0, 10, ValueColor.BLACK);
        assertFalse(rule.valid(pocket));
    }

    @Test
    public void valueGreaterThanTheUpperLimit() {
        rule = new RangeRule(25, 36);
        Pocket pocket = new Pocket(0, 38, ValueColor.BLACK);
        assertFalse(rule.valid(pocket));
    }
}