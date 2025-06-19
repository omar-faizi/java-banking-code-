import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            System.out.println("***************");
            System.out.println("Banking Program");
            System.out.println("***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("***************");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showBalance(balance);
                case 2 -> {
                    double depositAmount = deposit(scanner);
                    balance += depositAmount;
                }
                case 3 -> {
                    double withdrawAmount = withdraw(scanner);
                    if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                }
                case 4 -> {
                    isRunning = false;
                    System.out.println("Exiting... Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    static double deposit(Scanner scanner) {
        System.out.print("Enter amount to be deposited: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Deposit must be more than 0.");
            return 0;
        }
        return amount;
    }

    static double withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal must be more than 0.");
            return 0;
        }
        return amount;
    }
}
