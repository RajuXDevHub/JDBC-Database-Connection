import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Demo {

    /*  1. first put connector jar fill in the project
        2. then check the connection if all right to with the connection or not


        1.
        * Load the Driver Class
        *

        ** This is the checking code
        // Database URL
        String url = "jdbc:mysql://localhost:3306/Students";
        // Database credentials
        String username = "root";
        String password = "Raju@123";

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("✅ Connected to the database successfully!");
            System.out.println(connection);
        } catch (SQLException e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
        }



     */
    public static void main(String[] args) throws ClassNotFoundException {
        // Database URL
        String url = "jdbc:mysql://localhost:3306/Students";
        // Database credentials
        String username = "root";
        String password = "Raju@123";

        // Establish the connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("✅ Connected to the database successfully!");
            System.out.println(connection);
        } catch (SQLException e) {
            System.err.println("❌ Connection failed: " + e.getMessage());
        }

    }

}
