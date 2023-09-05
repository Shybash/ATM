import java.util.Scanner;

public class ATM {
    private static final int PIN = 3669;
    private static double balance = 1000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;

        System.out.println("Welcome to the Simple ATM");
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == PIN) {
                showMenu();
                break;
            } else {
                attempts--;
                System.out.println("Incorrect PIN. " + attempts + " attempts left.");
                if (attempts == 0) {
                    System.out.println("Too many incorrect attempts. Exiting.");
                    break;
                }
            }
        }

        scanner.close();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your balance: $" + balance);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: $");
                    double amountToWithdraw = scanner.nextDouble();
                    if (amountToWithdraw > 0 && amountToWithdraw <= balance) {
                        balance -= amountToWithdraw;
                        System.out.println("Withdrawal successful. Your new balance: $" + balance);
                    } else {
                        System.out.println("Invalid amount or insufficient funds.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: $");
                    double amountToDeposit = scanner.nextDouble();
                    if (amountToDeposit > 0) {
                        balance += amountToDeposit;
                        System.out.println("Deposit successful. Your new balance: $" + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Simple ATM. Have a nice day!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
