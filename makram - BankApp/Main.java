package org.BankApp;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("**** Welcome to Bank System ****");

        System.out.print("Enter account User name: ");
        String name = input.nextLine();

        System.out.print("Enter account number: ");
        int number = input.nextInt();

        System.out.print("Enter initial balance: ");
        double balance = input.nextDouble();

        BankAccount account = new BankAccount(name, number, balance);

        int choice;

        do {
            System.out.println("\n****** MENU ******");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Add Interest");
            System.out.println("5. Display Full Account Info");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.print("Enter interest rate (%): ");
                    double rate = input.nextDouble();
                    account.addInterest(rate);
                    break;

                case 5:
                    account.displayInfo();
                    break;

                case 6:
                    System.out.println("Thank you for using the bank system.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 6);


    }

    }