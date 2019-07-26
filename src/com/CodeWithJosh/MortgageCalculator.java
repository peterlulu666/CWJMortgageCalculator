package com.CodeWithJosh;

import java.text.NumberFormat;

public class MortgageCalculator {
    private final static byte Month_in_year = 12;
    private final static byte Percent = 100;

    private int principal;
    private float Annual_interest;
    private int years;

    public double[] getRemainingBalance() {
        var balances = new double[getNumber_of_payment()];
        for (var month = 1; month <= getNumber_of_payment(); month++) {
            var balance = CalculateBalance(month);
            balances[month - 1] = balance;
        }
        return balances;

    }

    public MortgageCalculator(int principal, float annual_interest, int years) {
        this.principal = principal;
        this.Annual_interest = annual_interest;
        this.years = years;
    }

    public double CalculateBalance(double Number_of_Payment_Made) {
        float Number_of_Payment = getNumber_of_payment();
        float Monthly_Interest = getMonthly_interest();

        double Balance = principal * (Math.pow(1 + Monthly_Interest, Number_of_Payment) - Math.pow(1 + Monthly_Interest, Number_of_Payment_Made)) /
                (Math.pow(1 + Monthly_Interest, Number_of_Payment) - 1);

        return Balance;

    }


    public double CalculateMortgage() {
        float Number_of_Payment = getNumber_of_payment();
        float Monthly_Interest = getMonthly_interest();

        double Mortgage = principal * (Monthly_Interest * Math.pow(1 + Monthly_Interest, Number_of_Payment)) /
                (Math.pow(1 + Monthly_Interest, Number_of_Payment) - 1);
        return Mortgage;
    }

    private float getMonthly_interest() {
        return (Annual_interest / Percent) / Month_in_year;
    }

    private int getNumber_of_payment() {
        return years * Month_in_year;
    }

}
