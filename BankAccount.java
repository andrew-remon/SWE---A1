package org.BankApp;

public class BankAccount {
    private String accountUser;
    private int accountId;
    private double balance;
    private int transactionCounter;


    public BankAccount(String name, int number, double initialBalance) {

        accountUser = name;
        accountId = number;

        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative.");
            balance = 0;
        } else {
            balance = initialBalance;
        }

        transactionCounter = 0;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCounter++;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        }
        else if (amount > balance) {
            System.out.println("There no enough balance!");
        }
        else {
            balance -= amount;
            transactionCounter++;
            System.out.println("Withdrawal successful!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }


    // Add interest
    public void addInterest(double rate) {
        if (rate > 0) {
            double interest = balance * rate / 100;
            balance += interest;
            transactionCounter++;
            System.out.println("Interest added: " + interest);
        } else {
            System.out.println("Invalid interest rate.");
        }
    }


    // Display full account info
    public void displayInfo() {
        System.out.println("\n--- Account Information ---");
        System.out.println("Account User: " + accountUser);
        System.out.println("Account Id: " + accountId);
        System.out.println("Balance: " + balance);
        System.out.println("Total Transactions: " + transactionCounter);
    }
}

