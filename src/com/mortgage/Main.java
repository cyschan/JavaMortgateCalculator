package com.mortgage;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public final static byte MONTH_IN_YEAR = 12;
    public final static byte PERCENTAGE = 100;

    static float calculate(float p, float r, short n) {
        float monthlyRate = r / MONTH_IN_YEAR / PERCENTAGE;
        short payments = (short) (n * MONTH_IN_YEAR);
        float onePRN = (float) Math.pow((monthlyRate + 1), payments);
        return p * ((monthlyRate * onePRN) / (onePRN - 1));
    }

    public static void main(String[] args) {
        float principal, rate;
        short period;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Principal:");
                principal = scanner.nextFloat();
                if (principal >= 1000 && principal <= 1_000_000) {
                    break;
                }
                System.out.println("Must be between 1000 and 1,000,000");
                continue;
            } catch (Exception e) {
                scanner.next();
            }
        }
        while (true) {
            try {
                System.out.print("Annual Interest Rate:");
                rate = scanner.nextFloat();
                if (rate > 0 && rate < 30) {
                    break;
                }
                System.out.println("Must be higher than 0 and lower than 30");
                continue;
            } catch (Exception e) {
                scanner.next();
            }
        }
        while (true) {
            try {
                System.out.print("Period (Years):");
                period = scanner.nextShort();
                if (period > 0 && period < 30) {
                    break;
                }
                System.out.println("Must be higher than 0 and lower than 30");
                continue;
            } catch (Exception e) {
                scanner.next();
            }
        }
        float results = calculate(principal, rate, period);
        System.out.printf("%s%s", "Mortgage: ", NumberFormat.getCurrencyInstance().format(results));
    }
}
