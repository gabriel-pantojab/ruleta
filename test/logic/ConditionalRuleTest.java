package logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalRuleTest {
    private ConditionalRule rule;

    @Test
    public void evenValue() {
        rule = new ConditionalRule(v -> v % 2 == 0);
        Pocket pocket = new Pocket(0, 12, ValueColor.RED);
        Pocket pocket1 = new Pocket(0, 13, ValueColor.RED);
        assertAll(
                () -> assertTrue(rule.valid(pocket)),
                () -> assertFalse(rule.valid(pocket1))
        );
    }

    @Test
    public void oddValue() {
        rule = new ConditionalRule(v -> v % 2 != 0);
        Pocket pocket = new Pocket(0, 13, ValueColor.RED);
        Pocket pocket1 = new Pocket(0, 22, ValueColor.RED);
        assertAll(
                ()->assertTrue(rule.valid(pocket)),
                () -> assertFalse(rule.valid(pocket1))
        );
    }
}