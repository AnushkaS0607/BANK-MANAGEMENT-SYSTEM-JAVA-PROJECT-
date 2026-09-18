package ASimulatorSystem;

import java.sql.*;

public class Signup2 {

    String formNumber;

    public Signup2(String formNumber) {
        this.formNumber = formNumber;
    }

    public void start() {

        System.out.println("\n--- ADDITIONAL DETAILS ---");

        String religion = Input.readLine("Enter religion: ");
        String category = Input.readLine("Enter category: ");
        String income = Input.readLine("Enter income: ");
        String education = Input.readLine("Enter education qualification: ");
        String occupation = Input.readLine("Enter occupation: ");
        String pan = Input.readLine("Enter PAN number: ");
        String aadhar = Input.readLine("Enter Aadhar number: ");
        String senior = Input.readLine("Are you a senior citizen? (Yes/No): ");
        String existing = Input.readLine("Do you have an existing account? (Yes/No): ");

        try {

            DatabaseConnection db = new DatabaseConnection();

            String query = "insert into signup2 values('" + formNumber + "','"
                    + religion + "','" + category + "','" + income + "','"
                    + education + "','" + occupation + "','" + pan + "','"
                    + aadhar + "','" + senior + "','" + existing + "')";

            db.s.executeUpdate(query);

            System.out.println("Additional details saved.");

            new Signup3(formNumber).start();

        } catch (Exception e) {
            System.out.println("Unable to save additional details.");
            e.printStackTrace();
        }
    }
}
