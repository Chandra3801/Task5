import java.util.ArrayList;
import java.util.Scanner;

// Account class
class Account {
    private String name;
    private double balance;
    private ArrayList<String> history;

    // Constructor
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.history = new ArrayList<>();
        history.add("Account started with: " + balance);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Added: " + amount + " | Balance: " + balance);
            System.out.println("Money added.");
        } else {
            System.out.println("Enter amount more than 0.");
        }
    }

    // Take out money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            history.add("Taken: " + amount + " | Balance: " + balance);
            System.out.println("Money taken.");
        } else {
            System.out.println("Not enough money or wrong amount.");
        }
    }

    // Show current balance
    public void showBalance() {
        System.out.println("Balance: " + balance);
    }

    // Show history
    public void showHistory() {
        System.out.println("\nAccount History:");
        for (String h : history) {
            System.out.println(h);
        }
    }
}

// Main program
public class BankAccountSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Make account
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter starting money: ");
        double money = sc.nextDouble();

        Account myAcc = new Account(name, money);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Add money");
            System.out.println("2. Take money");
            System.out.println("3. See balance");
            System.out.println("4. See account history");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double addAmt = sc.nextDouble();
                    myAcc.deposit(addAmt);
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    double takeAmt = sc.nextDouble();
                    myAcc.withdraw(takeAmt);
                    break;
                case 3:
                    myAcc.showBalance();
                    break;
                case 4:
                    myAcc.showHistory();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Wrong choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
