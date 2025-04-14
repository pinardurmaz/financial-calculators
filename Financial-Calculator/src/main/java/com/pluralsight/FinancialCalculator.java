package com.pluralsight;
import java.util.Scanner;
import java.util.Scanner;

public class FinancialCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n Financial Calculator ");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value (CD) Calculator");
            System.out.println("3. Present Value of Annuity Calculator");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                // Mortgage Calculator
                System.out.println("\n Mortgage Calculator ");
                System.out.print("Enter loan amount: ");
                double principal = scanner.nextDouble();
                System.out.print("Enter annual interest rate (e.g., 7.625): ");
                double annualInterestRate = scanner.nextDouble() / 100;
                System.out.print("Enter loan term in years: ");
                int years = scanner.nextInt();

                int n = years * 12;
                double i = annualInterestRate / 12;

                double monthlyPayment = principal * (i * Math.pow(1 + i, n)) / (Math.pow(1 + i, n) - 1);
                double totalInterest = (monthlyPayment * n) - principal;

                System.out.printf("Monthly payment: $%.2f\n", monthlyPayment);
                System.out.printf("Total interest paid: $%.2f\n", totalInterest);

            } else if (choice == 2) {
                // Future Value Calculator
                System.out.println("\n Future Value Calculator ");
                System.out.print("Enter deposit amount: ");
                double deposit = scanner.nextDouble();
                System.out.print("Enter annual interest rate (e.g., 1.75): ");
                double rate = scanner.nextDouble() / 100;
                System.out.print("Enter number of years: ");
                int years = scanner.nextInt();

                int totalDays = 365 * years;
                double dailyRate = rate / 365;

                double futureValue = deposit * Math.pow(1 + dailyRate, totalDays);
                double totalInterest = futureValue - deposit;

                System.out.printf("Future value: $%.2f\n", futureValue);
                System.out.printf("Total interest earned: $%.2f\n", totalInterest);

            } else if (choice == 3) {
                // Annuity Calculator
                System.out.println("\n--- Annuity Calculator ---");
                System.out.print("Enter monthly payment: ");
                double payment = scanner.nextDouble();
                System.out.print("Enter annual interest rate (e.g., 2.5): ");
                double rate = scanner.nextDouble() / 100;
                System.out.print("Enter number of years: ");
                int years = scanner.nextInt();

                int totalMonths = years * 12;
                double monthlyRate = rate / 12;

                double presentValue = payment * (1 - Math.pow(1 + monthlyRate, -totalMonths)) / monthlyRate;

                System.out.printf("Present value needed: $%.2f\n", presentValue);

            } else if (choice == 0) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}