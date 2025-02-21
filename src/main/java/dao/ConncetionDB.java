package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConncetionDB {

    private String url = "jdbc:postgresql://localhost:5432/masterannonce";
    private String user = "bhadadi";
    private String password = "bhadadi123";
    private static Connection connection;

    private ConncetionDB() throws ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getInstance() throws ClassNotFoundException {
        if(connection == null) {
            new ConncetionDB();
        }
        return connection;
    }

}
