package ASimulatorSystem;

import java.sql.*;

public class Login {

    public Login() {
    }

    public void start() {

        while (true) {

            System.out.println("\n--- ATM SYSTEM ---");
            System.out.println("Welcome to ATM");
            System.out.println("1. Sign In");
            System.out.println("2. Clear");
            System.out.println("3. Sign Up");
            System.out.println("4. Exit");

            String choice = Input.readLine("Enter your choice: ");

            try {

                if (choice.equals("1")) {

                    String cardNumber = Input.readLine("Enter Card Number: ");
                    String pin = Input.readLine("Enter PIN: ");

                    DatabaseConnection db = new DatabaseConnection();

                    String query = "select * from login where cardno = '"
                            + cardNumber + "' and pin = '" + pin + "'";

                    ResultSet rs = db.s.executeQuery(query);

                    if (rs.next()) {
                        System.out.println("Login successful.");
                        new Transactions(pin).start();
                    } else {
                        System.out.println("Incorrect Card Number or PIN.");
                    }

                } else if (choice.equals("2")) {

                    System.out.println("Card Number and PIN cleared.");

                } else if (choice.equals("3")) {

                    new Signup().start();

                } else if (choice.equals("4")) {

                    System.out.println("Thank you for using the ATM.");
                    break;

                } else {

                    System.out.println("Invalid choice. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Something went wrong while logging in.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.start();
    }
}

class Input {

    private static final java.io.BufferedReader br =
            new java.io.BufferedReader(
                    new java.io.InputStreamReader(System.in));

    static String readLine() {
        try {
            return br.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    static String readLine(String prompt) {
        System.out.print(prompt);
        return readLine();
    }

    static int readInt(String prompt) {

        while (true) {
            try {
                return Integer.parseInt(readLine(prompt).trim());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
