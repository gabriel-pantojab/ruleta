package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GameService {
    Conexion conexion = Conexion.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    public static GameService gameService;

    private GameService(){
    }

    public static GameService getInstance() {
        if(gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }
    public int insert(long balance, int userid){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("INSERT INTO game VALUES (?,?,?,?,?,?)");
            ps.setString(1,"0");
            ps.setLong(2,balance);
            ps.setLong(3,balance);
            ps.setInt(4,0);
            ps.setInt(5,0);
            ps.setInt(6, userid);
            ps.executeUpdate();
            ps = connection.prepareStatement("select last_insert_id()");
            rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            conexion.closeConnection();
            return id;
        }catch (Exception e){
            System.out.println("No se pudo insertar" + e);
        }
        return -1;
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

    public long selectCurrentBalanceGame(int idgame) {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT currentBalance FROM game WHERE idgame = ? ");
            ps.setInt(1, idgame);
            rs = ps.executeQuery();
            rs.next();
            long res = rs.getLong(1);
            conexion.closeConnection();
            return res;
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos " + e);
        }
        return 0;
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

    public void update(long currentBalance, long totalWinAmount, long totalLostAmoutn, int idgame){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("UPDATE game set currentBalance = ?, totalWinAmount = ?, totalLostAmount = ?  WHERE idgame = ?");
            ps.setLong(1, currentBalance);
            ps.setLong(2, totalWinAmount);
            ps.setLong(3, totalLostAmoutn);
            ps.setInt(4, idgame);
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

    public ArrayList<GameData> selectGamesUser(int id_user) {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT * FROM game WHERE " +
                    "user_id = ?");
            ps.setInt(1, id_user);
            rs = ps.executeQuery();

            ArrayList<GameData> games = new ArrayList<GameData>();
            while(rs.next()){
                int idGame = rs.getInt("idgame");
                int res = rs.getInt("balance");
                int current = rs.getInt("currentBalance");
                int win = rs.getInt("totalWinAmount");
                int lost = rs.getInt("totalLostAmount");
                games.add(new GameData(res+"", current+"",lost+"", win+"", idGame));
            }

            conexion.closeConnection();
            return games;
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos " + e);
        }
        return null;
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
