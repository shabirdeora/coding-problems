package com.shabir.problemsolving.anuj.recursion;

/**
 * Find the sum of n natural number using recursion.
 */
public class NaturalNumberSum {

    public static void main(String[] args) {
        System.out.println(calculateSum(5));
    }

    public static long calculateSum(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return n + calculateSum(n-1);
    }
}
