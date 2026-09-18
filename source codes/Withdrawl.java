package ASimulatorSystem;

import java.sql.*;

public class Withdrawl {

    String pin;

    public Withdrawl(String pin) {
        this.pin = pin;
    }

    public void start() {

        System.out.println("\n--- CASH WITHDRAWAL ---");

        int amount = Input.readInt("Enter amount to withdraw: ");

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        try {

            DatabaseConnection db = new DatabaseConnection();

            int balance = 0;

            String query = "select * from bank where pin = '" + pin + "'";
            ResultSet rs = db.s.executeQuery(query);

            while (rs.next()) {

                if (rs.getString("mode").equals("Deposit")) {
                    balance += rs.getInt("amount");
                } else {
                    balance -= rs.getInt("amount");
                }
            }

            if (balance < amount) {
                System.out.println("Insufficient balance.");
                return;
            }

            String insert = "insert into bank values('" + pin
                    + "', 'Withdrawl', " + amount + ")";

            db.s.executeUpdate(insert);

            System.out.println("Please collect your cash.");
            System.out.println("Rs. " + amount + " withdrawn successfully.");

        } catch (Exception e) {
            System.out.println("Unable to complete the withdrawal.");
            e.printStackTrace();
        }
    }
}
