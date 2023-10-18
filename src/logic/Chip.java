package logic;

/**
 * @author Gabriel Pantoja Bustamante
 * **/

public enum Chip {
    ONE(1L), FIVE(5L), TEN(10L), FIFTY(50L), HUNDRED(100L),
    FIVE_HUNDRED(500L),
    ONE_THOUSAND(1000L),
    TEN_THOUSAND(10000L),
    HUNDRED_THOUSAND(100000L),
            ONE_MILLION(1000000L), TEN_MILLION(10000000L),
    HUNDRED_MILLION(100000000L),
    ONE_BILLION(1000000000000L);
    private final long value;

    private Chip(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
