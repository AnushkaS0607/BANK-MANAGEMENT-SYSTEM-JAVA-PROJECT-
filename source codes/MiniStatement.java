package ASimulatorSystem;

import java.sql.*;

public class MiniStatement {

    String pin;

    public MiniStatement(String pin) {
        this.pin = pin;
    }

    public void start() {

        System.out.println("\n--- MINI STATEMENT ---");

        try {

            DatabaseConnection db = new DatabaseConnection();

            String query = "select * from bank where pin = '" + pin + "'";
            ResultSet rs = db.s.executeQuery(query);

            int balance = 0;

            System.out.println("Date\t\tMode\t\tAmount");
            System.out.println("------------------------------------------");

            while (rs.next()) {

                String mode = rs.getString("mode");
                int amount = rs.getInt("amount");

                System.out.println(rs.getString("date") + "\t"
                        + mode + "\t\tRs. " + amount);

                if (mode.equals("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }

            System.out.println("------------------------------------------");
            System.out.println("Available Balance: Rs. " + balance);

        } catch (Exception e) {
            System.out.println("Unable to display mini statement.");
            e.printStackTrace();
        }
    }
}
