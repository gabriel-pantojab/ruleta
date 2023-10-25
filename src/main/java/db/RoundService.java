package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoundService {
    Conexion conexion = Conexion.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    public static RoundService roundService;

    private RoundService(){
    }

    public  static RoundService getInstance() {
        if(roundService == null) {
            roundService = new RoundService();
        }
        return roundService;
    }

    public void insert(long winAmount, long lostAmount, long totalBetAmount, int idgame){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("INSERT INTO round VALUES (?,?,?,?,?)");
            ps.setString(1,"0");
            ps.setLong(2,winAmount);
            ps.setLong(3,lostAmount);
            ps.setLong(4, totalBetAmount);
            ps.setInt(5,idgame);
            ps.executeUpdate();
            GameService gameDB = GameService.getInstance();
            long win = gameDB.selectWinAmountGame(idgame) + winAmount;
            long lost = gameDB.selectLostAmountGame(idgame) + lostAmount;
            long currentBalance = gameDB.selectCurrentBalanceGame(idgame) - totalBetAmount + winAmount;
            gameDB.update(currentBalance, win,lost,idgame);
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo insertar la ronda " + e);
        }
    }

    public void deleteAll(){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("DELETE FROM round WHERE idround < 100000");
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo eliminar las rondas " + e);
        }
    }

    public void deleteWhere(int idround){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("DELETE FROM round WHERE idround = ?");
            ps.setInt(1,idround);
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo eliminar la ronda " + e);
        }
    }

    public void selectAll() {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT* FROM round");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("idround: " + rs.getInt(1) + "\n" +
                        "winAmount: " + rs.getString(2) + "\n" +
                        "lostAmount: " + rs.getString(3) + "\n" +
                        "idgame: " + rs.getInt(4));
            }
            conexion.closeConnection();
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todas las rondas " + e);
        }
    }
}
