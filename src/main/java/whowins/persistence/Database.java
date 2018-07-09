package whowins.persistence;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Freddie on 04/07/2018.
 */
public class Database {

    private static Connection c = null;

    public static void createConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:WhoWins.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}

