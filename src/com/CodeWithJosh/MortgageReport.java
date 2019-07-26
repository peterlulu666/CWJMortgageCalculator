package com.CodeWithJosh;

import java.text.NumberFormat;

public class MortgageReport {

    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }


    public void PrintBalance() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));

    }

    public void PrintMortgage() {
        double Mortgage = calculator.CalculateMortgage();
        String MortgageFormatted = NumberFormat.getCurrencyInstance().format(Mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage is: " + MortgageFormatted);
    }


}
