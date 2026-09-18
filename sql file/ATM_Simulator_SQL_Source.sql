-- ATM Simulator Database Source File
-- Database name used by the Java project: bms
-- MySQL

CREATE DATABASE IF NOT EXISTS bms;
USE bms;

-- -----------------------------------------------------
-- 1. SIGNUP TABLE
-- Stores the personal details entered during registration
-- Java: Signup.java
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS signup (
    formno VARCHAR(30) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    father_name VARCHAR(100),
    dob VARCHAR(30),
    gender VARCHAR(20),
    email VARCHAR(100),
    marital_status VARCHAR(30),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10)
);

-- -----------------------------------------------------
-- 2. SIGNUP2 TABLE
-- Stores additional applicant details
-- Java: Signup2.java
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS signup2 (
    formno VARCHAR(30) PRIMARY KEY,
    religion VARCHAR(50),
    category VARCHAR(50),
    income VARCHAR(50),
    education VARCHAR(100),
    occupation VARCHAR(100),
    pan VARCHAR(20),
    aadhar VARCHAR(20),
    senior VARCHAR(10),
    existing_account VARCHAR(10),
    FOREIGN KEY (formno) REFERENCES signup(formno)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- 3. SIGNUP3 TABLE
-- Stores account/card details
-- Java: Signup3.java
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS signup3 (
    formno VARCHAR(30) PRIMARY KEY,
    account_type VARCHAR(20),
    cardno VARCHAR(16) UNIQUE NOT NULL,
    pin VARCHAR(10) NOT NULL,
    services VARCHAR(255),
    FOREIGN KEY (formno) REFERENCES signup(formno)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- 4. LOGIN TABLE
-- Used by Login.java to authenticate the ATM user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS login (
    cardno VARCHAR(16) PRIMARY KEY,
    pin VARCHAR(10) NOT NULL,
    FOREIGN KEY (cardno) REFERENCES signup3(cardno)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- -----------------------------------------------------
-- 5. BANK TABLE
-- Stores every deposit and withdrawal transaction
-- Java classes: Deposit.java, Withdrawl.java,
-- FastCash.java, BalanceEquiry.java, MiniStatement.java
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS bank (
    pin VARCHAR(10) NOT NULL,
    mode VARCHAR(20) NOT NULL,
    amount INT NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------
-- OPTIONAL TEST DATA
-- Uncomment these lines if you want a test account.
-- -----------------------------------------------------

-- INSERT INTO signup
-- (formno, name, father_name, dob, gender, email, marital_status,
--  address, city, state, pincode)
-- VALUES
-- ('1001', 'Test User', 'Test Father', '01-01-2005', 'Female',
--  'test@example.com', 'Single', 'Test Address', 'Bhopal',
--  'Madhya Pradesh', '462001');

-- INSERT INTO signup2
-- (formno, religion, category, income, education, occupation,
--  pan, aadhar, senior, existing_account)
-- VALUES
-- ('1001', 'N/A', 'General', '500000', 'Student', 'Student',
--  'ABCDE1234F', '000000000000', 'No', 'No');

-- INSERT INTO signup3
-- (formno, account_type, cardno, pin, services)
-- VALUES
-- ('1001', 'Saving', '1234567890123456', '1234', 'ATM, Mobile Banking');

-- INSERT INTO login (cardno, pin)
-- VALUES ('1234567890123456', '1234');

-- INSERT INTO bank (pin, mode, amount)
-- VALUES ('1234', 'Deposit', 10000);

-- -----------------------------------------------------
-- Useful queries for checking the database
-- -----------------------------------------------------

-- SELECT * FROM signup;
-- SELECT * FROM signup2;
-- SELECT * FROM signup3;
-- SELECT * FROM login;
-- SELECT * FROM bank;

-- Check the current balance of a particular PIN:
-- SELECT
--     SUM(CASE
--         WHEN mode = 'Deposit' THEN amount
--         WHEN mode = 'Withdrawl' THEN -amount
--         ELSE 0
--     END) AS balance
-- FROM bank
-- WHERE pin = '1234';
