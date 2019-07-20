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

        double Mortgage = MortgageCalculator(principal, Annual_interest, years);

        String MortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);

        System.out.println("Mortgage is: " + MortgageFormatted);
    }

    public static double ReadNumber(String promt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while (true) {
            System.out.println(promt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    public static double MortgageCalculator(int principal,
                                            float Annual_interest,
                                            int years) {
        int Number_of_Payment = years * Month_in_year;
        float Monthly_Interest = (Annual_interest / Percent) / Month_in_year;

        double Mortgage = principal * (Monthly_Interest * Math.pow(1 + Monthly_Interest, Number_of_Payment)) /
                (Math.pow(1 + Monthly_Interest, Number_of_Payment) - 1);
        return Mortgage;
    }
}
