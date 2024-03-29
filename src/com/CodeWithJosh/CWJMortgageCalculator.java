package com.CodeWithJosh;

public class CWJMortgageCalculator {

    public static void main(String[] args) {
        int principal = (int) Console.ReadNumber("principal: ", 1000, 1_000_000);
        float Annual_interest = (float) Console.ReadNumber("Annual_interest: ", 1, 30);
        int years = (int) Console.ReadNumber("yeas: ", 1, 30);


        var calculator = new MortgageCalculator(principal, Annual_interest, years);
        var report = new MortgageReport(calculator);

        report.PrintBalance();
        report.PrintMortgage();


    }

}
