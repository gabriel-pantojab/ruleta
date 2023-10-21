package db;

import java.sql.*;
public class Conexion {
    private static Connection conexion;
    private static Conexion instance;
    private static final String URL = "jdbc:mysql://localhost:3306/db_roulette";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private String driver;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion(){
        driver = "com.mysql.jdbc.Driver";
        ps = null;
        rs = null;
    }

    public void connect(){

        try{
            //Class.forName(driver);
            //System.out.println("Driver cargado con exito");
            try {
                //Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }catch (Exception e){
                System.out.println("Error al conectar con la base de datos " + e);
            }
        }catch (Exception e){
            System.out.println("Error al cargar el driver " + e);
        }
    }

    public void closeConnection() throws SQLException{
        try{
            conexion.close();
        }catch (Exception e){
            System.out.println("Error al intertar cerrrar la conexion " + e);
            conexion.close();
        }finally {
            conexion.close();
        }
    }

    public static Conexion getInstance(){
        if(instance == null) instance = new Conexion();
        return instance;
    }

    public void selectAll() {
        try {
            ps = conexion.prepareStatement("SELECT* FROM usuario");
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("IdUsuario " + rs.getInt(1)+ "\n" +
                        "Nickname " + rs.getString(2) + "\n");
            }
        } catch (Exception e) {
            System.out.println("No se pudo seleccionar todos los datos " + e);
        }
    }

    public void selectWhere(String nickname){
        try{
            ps = conexion.prepareStatement("SELECT*FROM usuario WHERE nickname=?");
            ps.setString(1,nickname);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("IdUsuario " + rs.getInt(1)+ "\n" +
                        "Nickname " + rs.getString(2) + "\n");
            }
        }catch (Exception e){
            System.out.println("No se pudo seleccionar el dato " + e);
        }
    }

    public void insert(String nickname, String password){
        try {
            ps = conexion.prepareStatement("INSERT INTO usuario VALUES (?,?,?)");
            ps.setString(1,"0");
            ps.setString(2, nickname);
            ps.setString(3, password);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("No se pudo conectar" + e);
        }
    }

    public void deleteAll(){
        try{
            ps = conexion.prepareStatement("DELETE* FROM usuario");

        }catch (Exception e){
            System.out.println("No se pudo eliminar el dato " + e);
        }
    }

    public void deleteWhere(int id){
        try{
            ps = conexion.prepareStatement("DELETE FROM usuario WHERE idusuario = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){
            System.out.println("No se pudo eliminar el dato " + e);
        }
    }

}
