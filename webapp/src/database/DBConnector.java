package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by User on 2016.08.15..
 */
public class DBConnector {
    public static Connection connectDb() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306:dbsanta");
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
