package ASimulatorSystem;

import java.sql.*;

class BalanceEnquiry {

    String pin;

    public BalanceEnquiry(String pin) {
        this.pin = pin;
    }

    public void start() {

        System.out.println("\n--- BALANCE ENQUIRY ---");

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

            System.out.println("Your current balance is: Rs. " + balance);

        } catch (Exception e) {
            System.out.println("Unable to check balance.");
            e.printStackTrace();
        }
    }
}
