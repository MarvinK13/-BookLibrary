package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static final String DATABASE_NAME = "bookLibrar";
    public static final String USER = "root";
    public static final String PASSWORD = "hallo";

    public DatabaseConnection() {

    }

    public Connection getConnection() throws SQLException {
        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/" + DATABASE_NAME, USER, PASSWORD);
    }

}