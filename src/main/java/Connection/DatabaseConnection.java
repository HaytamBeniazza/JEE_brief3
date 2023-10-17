package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;
    private static String User = "postgres";
    private static String PASS = "1234";
    private static String Host = "jdbc:postgresql://localhost:5432/jeeDB";

    private DatabaseConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(Host, User, PASS);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if(connection == null){
            connection = new DatabaseConnection().getConnection();
        }
        return connection;
    }
}
