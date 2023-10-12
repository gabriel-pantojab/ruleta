/**
 * @author Esther Romero Aguilar
 * */

import logic.*;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Boolean> f = v -> v % 2 == 0;
        ConditionalRule c = new ConditionalRule(f);
        System.out.println(c.valid(new Pocket(0, 3, ValueColor.RED)));
    }
}