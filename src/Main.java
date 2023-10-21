/**
 * @author Esther Romero Aguilar
 * */

import logic.*;
import view.ControlGame;
import view.RouletteGame;
import view.TableView;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        try{
            Game game = new Game(2500L);
            TableView table = new TableView(game.getBettingGrid());
            ControlGame control = new ControlGame(game, table);
            new RouletteGame(table);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}