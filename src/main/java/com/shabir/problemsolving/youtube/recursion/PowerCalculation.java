package com.shabir.problemsolving.youtube.recursion;

/**
 * Calculate the power of b to the base a
 */
public class PowerCalculation {

    private static long calculatePower(int a, int b) {
        if (a <= 0 || b < 0) {
            return 0;
        }
        if (a == 1 || b == 0) {
            return 1;
        }
        return a * calculatePower(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2, 31));
    }
}
