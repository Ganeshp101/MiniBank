import java.util.HashMap;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private double balance;

    public Account(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance is " + balance + ".");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance is " + balance + ".");
        } else {
            System.out.println("Your Bank Balance might be less, than you Entered Amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance is " + balance + ".");
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class MiniBank {

    private static HashMap<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMini Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting the Mini Bank System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        accounts.put(name, new Account(name, initialBalance));
        System.out.println("Account created for " + name + " with balance " + initialBalance + ".");
    }

    private static void depositMoney() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        Account account = accounts.get(name);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        Account account = accounts.get(name);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        Account account = accounts.get(name);
        if (account != null) {
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }
}