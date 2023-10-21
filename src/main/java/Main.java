/**
 * @author Esther Romero Aguilar
 * */

import db.Conexion;

public class Main {
    static Conexion conexion = Conexion.getInstance();

    public static void main(String[] args) {
        try {
            conexion.connect();
            //conexion.insert("Wilson", "wili");
            conexion.selectAll();
            conexion.deleteWhere(4);
            conexion.selectAll();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println(e);
        }
//        try{
//            Game game = new Game(2500L);
//            TableView table = new TableView(game.getBettingGrid());
//            ControlGame control = new ControlGame(game, table);
//            table.updateChipsAvailable(game.getChipsAvailable());
//            new RouletteGame(table);
//        }catch (Exception e){}
    }
}