package ASimulatorSystem;

public class Transactions {

    String pin;

    public Transactions(String pin) {
        this.pin = pin;
    }

    public void start() {

        while (true) {

            System.out.println("\n--- TRANSACTIONS ---");
            System.out.println("1. Deposit");
            System.out.println("2. Cash Withdrawl");
            System.out.println("3. Fast Cash");
            System.out.println("4. Mini Statement");
            System.out.println("5. PIN Change");
            System.out.println("6. Balance Enquiry");
            System.out.println("7. Exit");

            String choice = Input.readLine("Enter your choice: ");

            try {

                if (choice.equals("1")) {
                    new Deposit(pin).start();

                } else if (choice.equals("2")) {
                    new Withdrawl(pin).start();

                } else if (choice.equals("3")) {
                    new FastCash(pin).start();

                } else if (choice.equals("4")) {
                    new MiniStatement(pin).start();

                } else if (choice.equals("5")) {
                    new Pin(pin).start();

                } else if (choice.equals("6")) {
                    new BalanceEnquiry(pin).start();

                } else if (choice.equals("7")) {
                    System.out.println("Returning to login...");
                    break;

                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Unable to process the transaction.");
                e.printStackTrace();
            }
        }
    }
}
