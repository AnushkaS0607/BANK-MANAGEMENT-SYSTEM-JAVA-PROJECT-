-- ATM Simulator database setup
-- Run this file in MySQL Workbench or the MySQL command line.

CREATE DATABASE IF NOT EXISTS bms;
USE bms;

CREATE TABLE IF NOT EXISTS signup (
    formno VARCHAR(30) NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    father_name VARCHAR(100),
    date_of_birth VARCHAR(30),
    gender VARCHAR(20),
    email VARCHAR(100),
    marital_status VARCHAR(30),
    address VARCHAR(255),
    city VARCHAR(80),
    state VARCHAR(80),
    pincode VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS signup2 (
    formno VARCHAR(30) NOT NULL PRIMARY KEY,
    religion VARCHAR(50),
    category VARCHAR(50),
    income VARCHAR(50),
    education VARCHAR(100),
    occupation VARCHAR(100),
    pan VARCHAR(30),
    aadhar VARCHAR(30),
    senior_citizen VARCHAR(10),
    existing_account VARCHAR(10),
    CONSTRAINT fk_signup2_formno FOREIGN KEY (formno) REFERENCES signup(formno)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS signup3 (
    formno VARCHAR(30) NOT NULL PRIMARY KEY,
    account_type VARCHAR(30),
    cardno VARCHAR(30) UNIQUE,
    pin VARCHAR(20),
    services VARCHAR(255),
    CONSTRAINT fk_signup3_formno FOREIGN KEY (formno) REFERENCES signup(formno)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS login (
    cardno VARCHAR(30) NOT NULL PRIMARY KEY,
    pin VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS bank (
    pin VARCHAR(20) NOT NULL,
    date VARCHAR(100) NOT NULL,
    mode VARCHAR(30) NOT NULL,
    amount INT NOT NULL
);

-- Optional test account. Remove these lines if you want a completely empty database.
-- Card number: 1234567890123456
-- PIN: 1234
INSERT INTO login (cardno, pin)
SELECT '1234567890123456', '1234'
WHERE NOT EXISTS (
    SELECT 1 FROM login WHERE cardno = '1234567890123456'
);

INSERT INTO signup (formno, name, father_name, date_of_birth, gender, email, marital_status, address, city, state, pincode)
SELECT 'TEST001', 'Test User', 'Test Father', '01-01-2000', 'Other', 'test@example.com', 'Single', 'Test Address', 'Indore', 'Madhya Pradesh', '452001'
WHERE NOT EXISTS (
    SELECT 1 FROM signup WHERE formno = 'TEST001'
);

INSERT INTO signup2 (formno, religion, category, income, education, occupation, pan, aadhar, senior_citizen, existing_account)
SELECT 'TEST001', 'Not Specified', 'General', 'Not Specified', 'Student', 'Student', 'TESTPAN', 'TESTAADHAR', 'No', 'No'
WHERE NOT EXISTS (
    SELECT 1 FROM signup2 WHERE formno = 'TEST001'
);

INSERT INTO signup3 (formno, account_type, cardno, pin, services)
SELECT 'TEST001', 'Saving', '1234567890123456', '1234', 'ATM, Mobile Banking'
WHERE NOT EXISTS (
    SELECT 1 FROM signup3 WHERE formno = 'TEST001'
);

-- A small starting balance for the test account.
INSERT INTO bank (pin, date, mode, amount)
SELECT '1234', NOW(), 'Deposit', 5000
WHERE NOT EXISTS (
    SELECT 1 FROM bank WHERE pin = '1234'
);

SELECT 'bms database setup completed.' AS message;
