package com.CodeWithJosh;

public class CWJMortgageCalculator {

    public static void main(String[] args) {
        int principal = (int) Concole.ReadNumber("principal: ", 1000, 1_000_000);
        float Annual_interest = (float) Concole.ReadNumber("Annual_interest: ", 1, 30);
        int years = (int) Concole.ReadNumber("yeas: ", 1, 30);


        var calculator = new MortgageCalculator(principal, Annual_interest, years);
        var report = new MortgageReport(calculator);

        report.PrintBalance();
        report.PrintMortgage();


    }

}
