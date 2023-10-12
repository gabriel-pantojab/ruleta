/**
 * @author Esther Romero Aguilar
 * */

import logic.*;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Boolean> f = v -> v % 2 == 0;
        RuleBet c = new SetRule(new int[]{1, 2, 3, 4});
        System.out.println(c.valid(new Pocket(0, 5, ValueColor.RED)));
    }
}