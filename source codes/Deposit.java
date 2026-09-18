package ASimulatorSystem;

import java.sql.*;

public class Deposit {

    String pin;

    public Deposit(String pin) {
        this.pin = pin;
    }

    public void start() {

        System.out.println("\n--- DEPOSIT ---");

        int amount = Input.readInt("Enter amount to deposit: ");

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        try {

            DatabaseConnection db = new DatabaseConnection();

            String query = "insert into bank values('" + pin
                    + "', 'Deposit', " + amount + ")";

            db.s.executeUpdate(query);

            System.out.println("Rs. " + amount + " deposited successfully.");

        } catch (Exception e) {
            System.out.println("Unable to complete the deposit.");
            e.printStackTrace();
        }
    }
}
