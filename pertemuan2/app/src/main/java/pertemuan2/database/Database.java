package pertemuan2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String DATABASE = "prak_pbo";
    public static final String PORT = "5432";
    public static final String HOST = "localhost";
    public static final String USER = "developer";
    public static final String PASSWORD = "developer123";
    public static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE;

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed!");
            e.printStackTrace();
            return null;
        }
    }
}
