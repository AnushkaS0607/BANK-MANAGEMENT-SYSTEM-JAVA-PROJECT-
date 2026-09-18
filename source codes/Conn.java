package ASimulatorSystem;

import java.sql.*;

class DatabaseConnection {

    Connection c;
    Statement s;

    DatabaseConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            c = DriverManager.getConnection(
                    "jdbc:mysql:///bms", "root", "root");

            s = c.createStatement();

        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
