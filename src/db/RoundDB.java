package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoundDB {
    Conexion conexion = Conexion.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;

    public RoundDB(){
    }

    public void insert(int winAmount, int lostAmount, int idgame){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("INSERT INTO round VALUES (?,?,?,?)");
            ps.setString(1,"0");
            ps.setInt(2,winAmount);
            ps.setInt(3,lostAmount);
            ps.setInt(4,idgame);
            ps.executeUpdate();
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
