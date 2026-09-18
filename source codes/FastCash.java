package ASimulatorSystem;

import java.sql.*;

public class FastCash {

    String pin;

    public FastCash(String pin) {
        this.pin = pin;
    }

    public void start() {

        while (true) {

            System.out.println("\n--- FAST CASH ---");
            System.out.println("1. Rs. 100");
            System.out.println("2. Rs. 500");
            System.out.println("3. Rs. 1000");
            System.out.println("4. Rs. 2000");
            System.out.println("5. Rs. 5000");
            System.out.println("6. Rs. 10000");
            System.out.println("7. Back");

            String choice = Input.readLine("Enter your choice: ");

            int amount = 0;

            if (choice.equals("1")) {
                amount = 100;
            } else if (choice.equals("2")) {
                amount = 500;
            } else if (choice.equals("3")) {
                amount = 1000;
            } else if (choice.equals("4")) {
                amount = 2000;
            } else if (choice.equals("5")) {
                amount = 5000;
            } else if (choice.equals("6")) {
                amount = 10000;
            } else if (choice.equals("7")) {
                break;
            } else {
                System.out.println("Invalid choice.");
                continue;
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
                    continue;
                }

                String insert = "insert into bank values('" + pin
                        + "', 'Withdrawl', " + amount + ")";

                db.s.executeUpdate(insert);

                System.out.println("Please collect your cash.");
                System.out.println("Rs. " + amount + " withdrawn successfully.");

            } catch (Exception e) {
                System.out.println("Unable to process fast cash.");
                e.printStackTrace();
            }
        }
    }
}
