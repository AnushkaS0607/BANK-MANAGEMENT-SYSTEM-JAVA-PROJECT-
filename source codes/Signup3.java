package ASimulatorSystem;

import java.sql.*;
import java.util.Random;

public class Signup3 {

    String formNumber;

    public Signup3(String formNumber) {
        this.formNumber = formNumber;
    }

    public void start() {

        System.out.println("\n--- ACCOUNT DETAILS ---");

        String accountType = Input.readLine(
                "Enter account type (Saving/Current): ");

        String services = Input.readLine(
                "Enter required services: ");

        String declaration = Input.readLine(
                "Do you agree to the declaration? (Yes/No): ");

        if (!declaration.equalsIgnoreCase("Yes")) {
            System.out.println("Account creation cancelled.");
            return;
        }

        Random random = new Random();

        String cardNumber = "" + Math.abs(random.nextLong() % 9000000000000000L + 1000000000000000L);
        String pin = "" + (1000 + random.nextInt(9000));

        try {

            DatabaseConnection db = new DatabaseConnection();

            String query = "insert into signup3 values('" + formNumber + "','"
                    + accountType + "','" + cardNumber + "','" + pin + "','"
                    + services + "')";

            db.s.executeUpdate(query);

            String loginQuery = "insert into login values('"
                    + cardNumber + "','" + pin + "')";

            db.s.executeUpdate(loginQuery);

            System.out.println("\nAccount created successfully!");
            System.out.println("Your Card Number: " + cardNumber);
            System.out.println("Your PIN: " + pin);
            System.out.println("Please keep these details safe.");

            new Deposit(pin).start();

        } catch (Exception e) {
            System.out.println("Unable to create the account.");
            e.printStackTrace();
        }
    }
}
