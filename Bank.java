import java.util.Scanner;

class BankAccount {
    private float balance;

    public BankAccount(float initialBalance) {
        this.balance = initialBalance;
    }

    public float getBalance() {
        return balance;
    }

    public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("1. Check balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void start() {
        int option;
        do {
            displayMenu();
            System.out.print("Enter option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline not consumed by nextInt()

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 4);
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.getBalance());
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        float amount = scanner.nextFloat();
        account.deposit(amount);
        System.out.println("Deposit successful.");
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM(account, scanner);
        atm.start();
    }
}