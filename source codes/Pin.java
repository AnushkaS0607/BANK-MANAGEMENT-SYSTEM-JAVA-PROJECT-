package ASimulatorSystem;

import java.sql.*;

public class Pin {

    String pin;

    public Pin(String pin) {
        this.pin = pin;
    }

    public void start() {

        System.out.println("\n--- PIN CHANGE ---");

        String newPin = Input.readLine("Enter new PIN: ");
        String confirmPin = Input.readLine("Confirm new PIN: ");

        if (!newPin.equals(confirmPin)) {
            System.out.println("PINs do not match.");
            return;
        }

        if (newPin.length() == 0) {
            System.out.println("PIN cannot be empty.");
            return;
        }

        try {

            DatabaseConnection db = new DatabaseConnection();

            String bankQuery = "update bank set pin = '" + newPin
                    + "' where pin = '" + pin + "'";
            db.s.executeUpdate(bankQuery);

            String loginQuery = "update login set pin = '" + newPin
                    + "' where pin = '" + pin + "'";
            db.s.executeUpdate(loginQuery);

            String signupQuery = "update signup3 set pin = '" + newPin
                    + "' where pin = '" + pin + "'";
            db.s.executeUpdate(signupQuery);

            System.out.println("PIN changed successfully.");

        } catch (Exception e) {
            System.out.println("Unable to change PIN.");
            e.printStackTrace();
        }
    }
}
