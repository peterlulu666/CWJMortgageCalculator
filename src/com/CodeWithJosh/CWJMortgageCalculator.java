package com.CodeWithJosh;

import java.text.NumberFormat;
import java.util.Scanner;

public class CWJMortgageCalculator {
    final static byte Month_in_year = 12;
    final static byte Percent = 100;

    public static void main(String[] args) {
        int principal = (int) ReadNumber("principal: ", 1000, 1_000_000);
        float Annual_interest = (float) ReadNumber("Annual_interest: ", 1, 30);
        int years = (int) ReadNumber("yeas: ", 1, 30);

        PrintMortgage(principal, Annual_interest, years);

        PrintBalance(principal, Annual_interest, years);

    }

    public static void PrintBalance(int principal, float annual_interest, int years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double month = 1; month <= years * Month_in_year; month++) {
            double balance = BalanceCalculator(principal, annual_interest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static void PrintMortgage(int principal, float annual_interest, int years) {
        double Mortgage = MortgageCalculator(principal, annual_interest, years);
        String MortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage is: " + MortgageFormatted);
    }

    public static double ReadNumber(String promt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(promt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double BalanceCalculator(int principal,
                                           float Annual_interest,
                                           int years,
                                           double Number_of_Payment_Made) {
        float Number_of_Payment = years * Month_in_year;
        float Monthly_Interest = (Annual_interest / Percent) / Month_in_year;

        double Balance = principal * (Math.pow(1 + Monthly_Interest, Number_of_Payment) - Math.pow(1 + Monthly_Interest, Number_of_Payment_Made)) /
                (Math.pow(1 + Monthly_Interest, Number_of_Payment) - 1);

        return Balance;

    }

    public static double MortgageCalculator(int principal,
                                            float Annual_interest,
                                            int years) {
        float Number_of_Payment = years * Month_in_year;
        float Monthly_Interest = (Annual_interest / Percent) / Month_in_year;

        double Mortgage = principal * (Monthly_Interest * Math.pow(1 + Monthly_Interest, Number_of_Payment)) /
                (Math.pow(1 + Monthly_Interest, Number_of_Payment) - 1);
        return Mortgage;
    }
}
