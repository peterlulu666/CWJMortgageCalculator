package com.CodeWithJosh;

import java.util.Scanner;

public class Concole {
    private static Scanner scanner = new Scanner(System.in);

    public static double ReadNumber(String primt){
        return scanner.nextDouble();
    }

    public static double ReadNumber(String promt, double min, double max) {
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
}
