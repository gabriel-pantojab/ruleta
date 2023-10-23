package db;

import logic.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {
    Conexion conexion = Conexion.getInstance();
    private PreparedStatement ps;
    private ResultSet rs;
    public static UserService userdb;

    private UserService(){
        ps = null;
        rs = null;
    }

    public static UserService getInstance() {
        if(userdb == null) {
            userdb = new UserService();
        }
        return userdb;
    }
    public void insert(User user){
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT COUNT(*) FROM user WHERE nickname = ?");
            ps.setString(1,user.getNickname());
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("El nickname ya está en uso. Por favor, elige otro.");
            } else {
                ps = connection.prepareStatement("INSERT INTO user VALUES (?,?,?)");
                ps.setString(1,"0");
                ps.setString(2, user.getNickname());
                ps.setString(3, user.getPassword());
                ps.executeUpdate();
            }
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo insertar al usuario. " + e);
        }
    }

    public void deleteAll(){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("DELETE FROM user WHERE iduser < 10000");
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo eliminar los usuarios. " + e);
        }
    }

    public void deleteWhere(String nickname){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("DELETE FROM user WHERE nickname = ?");
            ps.setString(1,nickname);
            ps.executeUpdate();
            conexion.closeConnection();
        }catch (Exception e){
            System.out.println("No se pudo eliminar el usuario. " + e);
        }
    }

    public void selectAll() {
        try {
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT* FROM user");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("iduser: " + rs.getInt(1)+ "\n" +
                        "nickname: " + rs.getString(2));
            }
            conexion.closeConnection();
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos. " + e);
        }
    }

    public int selectID(String nickname){
        try{
            Connection connection = conexion.connect();
            ps = connection.prepareStatement("SELECT*FROM user WHERE nickname=?");
            ps.setString(1, nickname);
            rs = ps.executeQuery();
            rs.next();
            int res = rs.getInt(1);
            conexion.closeConnection();
            return res;
        }catch (Exception e){
            System.out.println("No se pudo seleccionar el dato. " + e);
        }
        return 0;
    }
}