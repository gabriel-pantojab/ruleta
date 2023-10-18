/**
 * @author Esther Romero Aguilar
 * */

import logic.*;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Round round = new Round();
        Bet b1 =  new FirstDozenRange(Chip.TEN);
        Bet b2 = new RedColor(Chip.TEN);
        round.toBet(b1);
        round.toBet(b2);
        System.out.println(round.calculateWinAmount(new Pocket(0, 10, ValueColor.BLACK)));
    }
}