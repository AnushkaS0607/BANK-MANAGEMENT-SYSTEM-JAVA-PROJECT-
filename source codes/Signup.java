package ASimulatorSystem;

import java.sql.*;

public class Signup {

    public void start() {

        System.out.println("\n--- ACCOUNT REGISTRATION ---");

        String formNumber = Input.readLine("Enter form number: ");
        String name = Input.readLine("Enter name: ");
        String fatherName = Input.readLine("Enter father's name: ");
        String dateOfBirth = Input.readLine("Enter date of birth: ");
        String gender = Input.readLine("Enter gender: ");
        String email = Input.readLine("Enter email: ");
        String marital = Input.readLine("Enter marital status: ");
        String address = Input.readLine("Enter address: ");
        String city = Input.readLine("Enter city: ");
        String state = Input.readLine("Enter state: ");
        String pin = Input.readLine("Enter pincode: ");

        try {

            DatabaseConnection db = new DatabaseConnection();

            String query = "insert into signup values('" + formNumber + "','"
                    + name + "','" + fatherName + "','" + dateOfBirth + "','"
                    + gender + "','" + email + "','" + marital + "','"
                    + address + "','" + city + "','" + state + "','"
                    + pin + "')";

            db.s.executeUpdate(query);

            System.out.println("Personal details saved.");

            new Signup2(formNumber).start();

        } catch (Exception e) {
            System.out.println("Unable to save personal details.");
            e.printStackTrace();
        }
    }
}
