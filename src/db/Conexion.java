package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static Connection conexion;
    private static Conexion instance;
    private static final String URL = "jdbc:mysql://localhost:3306/db_roulette";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Conexion(){
    }

    public Connection connect(){
        try {
            conexion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (Exception e){
            System.out.println("Error al conectar con la base de datos " + e);
        }
        return conexion;
    }

    public void closeConnection() throws SQLException {
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
}
