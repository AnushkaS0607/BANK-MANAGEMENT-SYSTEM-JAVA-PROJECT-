# BANK-MANAGEMENT-SYSTEM-JAVA-PROJECT-
BANK MANAGEMENT SYSTEM (ATM SIMULATOR)
# BANK MANAGEMENT SYSTEM (ATM SIMULATOR)

## Project Title

BANK MANAGEMENT SYSTEM (ATM Simulator)

## Overview of the Project

The ATM Simulator is a Java-based banking application that simulates
common Automated Teller Machine operations. It provides a graphical
interface for user registration, login using a card number and PIN, and
banking transactions. MySQL is used to store registration, account,
login, and transaction information.

## Features

-   New user registration
-   Personal, additional, and account details
-   Card number and PIN generation
-   Card number and PIN based login
-   Deposit
-   Withdraw
-   Fast Cash
-   Balance Enquiry
-   Mini Statement
-   PIN Change
-   MySQL database integration
-   Transaction record storage

## Technologies / Tools Used

-   Java
-   Java Swing
-   MySQL
-   JDBC
-   MySQL Connector/J
-   Java IDE such as IntelliJ IDEA, Eclipse, or NetBeans

## Steps to Install & Run the Project

1.  Install the Java JDK.
2.  Install MySQL Server.
3.  Create the `bms` database.
4.  Run the provided SQL source file to create the required tables.
5.  Add MySQL Connector/J to the Java project.
6.  Open the project in a Java IDE.
7.  Configure the MySQL username, password, and connection details in
    `DatabaseConnection.java`.
8.  Compile and run the project.
9.  Register a new user or use an available test account.

## Instructions for Testing

1.  Start the ATM Simulator.
2.  Test the signup process with valid details.
3.  Verify that the account and card details are stored in the database.
4.  Log in using the card number and PIN.
5.  Test Deposit, Withdraw, Fast Cash, Balance Enquiry, Mini Statement,
    and PIN Change.
6.  Verify transaction records in the `bank` table.
7.  Test invalid login credentials and verify that access is rejected.
8.  Check the MySQL tables to confirm that data is stored and retrieved
    correctly.
