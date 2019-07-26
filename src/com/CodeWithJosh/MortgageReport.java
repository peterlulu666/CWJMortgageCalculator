package com.CodeWithJosh;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }


    public void PrintBalance() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(currency.format(balance));

    }

    public void PrintMortgage() {
        double Mortgage = calculator.CalculateMortgage();
        String MortgageFormatted = currency.format(Mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Mortgage is: " + MortgageFormatted);
    }


}
