package db;

import logic.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GameDB {
    Conexion conexion = Conexion.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;

    public GameDB(){
    }

    public void insert(Game game, int idUser, int totalWinAmount, int totalLostAmount){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("INSERT INTO game VALUES (?,?,?,?,?)");
            ps.setString(1,"0");
            ps.setLong(2,game.getBalance());
            ps.setInt(4,totalWinAmount);
            ps.setInt(5,totalLostAmount);
            ps.setInt(3,idUser);
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo insertar" + e);
        }
    }

    public void deleteAll(){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("DELETE FROM game WHERE idgame < 100000");
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo eliminar el dato " + e);
        }
    }

    public void deleteWhere(int idgame){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("DELETE FROM game WHERE idgame = ?");
            ps.setInt(1,idgame);
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo eliminar el dato " + e);
        }
    }

    public void selectAll() {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT* FROM game");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("idgame: " + rs.getInt(1) + "\n" +
                        "balance: " + rs.getString(2) + "\n" +
                        "totalWinAmount: " + rs.getString(3) + "\n" +
                        "totalLostAmount: " + rs.getString(4) + "\n" +
                        "iduser: " + rs.getInt(5));
            }
            conexion.closeConnection();
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos " + e);
        }
    }

    public int selectIDGame(int totalWinAmount, int totalLostAmount, String nickname){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT idgame FROM game WHERE totalWinAmount = ? AND totalLostAmount = ? AND user_id=(SELECT iduser FROM user WHERE nickname = ?);");
            ps.setInt(1, totalWinAmount);
            ps.setInt(2, totalLostAmount);
            ps.setString(3, nickname);
            rs = ps.executeQuery();
            rs.next();
            int res = rs.getInt(1);
            conexion.closeConnection();
            return res;
        }catch (Exception e){
            System.out.println("No se pudo seleccionar las partidas " + e);
        }
        return 0;
    }

    public void selectGames(String nickname){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT idgame FROM game WHERE user_id=(SELECT iduser FROM user WHERE nickname = ?)");
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("idgame: " + rs.getInt(1));
            }
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo seleccionar las partidas " + e);
        }
    }

    public int selectWinAmountGame(int idgame) {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT totalWinAmount FROM game WHERE idgame = ? ");
            ps.setInt(1, idgame);
            rs = ps.executeQuery();
            rs.next();
            int res = rs.getInt(1);
            conexion.closeConnection();
            return res;
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos " + e);
        }
        return 0;
    }

    public int selectLostAmountGame(int idgame) {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT totalLostAmount FROM game WHERE idgame = ? ");
            ps.setInt(1, idgame);
            rs = ps.executeQuery();
            rs.next();
            int res = rs.getInt(1);
            conexion.closeConnection();
            return res;
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos " + e);
        }
        return 0;
    }

    public void update(int totalWinAmount, int totalLostAmoutn, int idgame){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("UPDATE game set totalWinAmount = ?, totalLostAmount = ?  WHERE idgame = ?");
            ps.setInt(1, totalWinAmount);
            ps.setInt(2, totalLostAmoutn);
            ps.setInt(3, idgame);
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo actualizar la partida. " + e);
        }
    }

    public void updateBalance(int balance, int idgame){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("UPDATE game set balance = ?  WHERE idgame = ?");
            ps.setInt(1, balance);
            ps.setInt(2, idgame);
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo actualizar el balance de la partida. " + e);
        }
    }

    public void selectGamesAndRoundsForUser(String nickname) {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT game.idgame, game.balance, game.totalWinAmount, game.totalLostAmount, round.idround, round.winAmount, round.lostAmount " +
                    "FROM game " +
                    "JOIN user ON game.user_id = user.iduser " +
                    "LEFT JOIN round ON game.idgame = round.game_id " +
                    "WHERE user.nickname = ?");
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            showTable(rs);
            conexion.closeConnection();
        } catch (Exception e) {
            System.out.println("No se pudieron seleccionar los juegos y rondas para el usuario " + e);
        }
    }

    private void showTable(ResultSet rss){
        try{
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("| %-8s | %-12s | %-15s | %-15s | %-8s | %-12s | %-12s |\n",
                    "ID Game", "Balance", "Total Ganado", "Total Perdido", "ID Round", "Monto Ganado", "Monto Perdido");
            System.out.println("-----------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("| %-8d | %-12.2f | %-15.2f | %-15.2f | %-8d | %-12.2f | %-12.2f |\n",
                        rss.getInt("idgame"),
                        rss.getBigDecimal("balance"),
                        rss.getBigDecimal("totalWinAmount"),
                        rss.getBigDecimal("totalLostAmount"),
                        rss.getInt("idround"),
                        rss.getBigDecimal("winAmount"),
                        rss.getBigDecimal("lostAmount"));
            }

            System.out.println("-----------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println("No se pudo mostrar la tabla. " + e);
        }
    }
}
