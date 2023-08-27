package com.shabir.problemsolving.anuj.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NaturalNumberSumTest {

    @Test
    public void testCase1CalculateSum() {
        long expectedResult = 0;
        long actualResult = NaturalNumberSum.calculateSum(0);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase2CalculateSum() {
        long expectedResult = 0;
        long actualResult = NaturalNumberSum.calculateSum(-5);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase3CalculateSum() {
        long expectedResult = 1;
        long actualResult = NaturalNumberSum.calculateSum(1);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase4CalculateSum() {
        long expectedResult = 3;
        long actualResult = NaturalNumberSum.calculateSum(2);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase5CalculateSum() {
        long expectedResult = 5 * 3;
        long actualResult = NaturalNumberSum.calculateSum(5);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase6CalculateSum() {
        long expectedResult = 25 * 51;
        long actualResult = NaturalNumberSum.calculateSum(50);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase7CalculateSum() {
        long expectedResult = 50 * 101;
        long actualResult = NaturalNumberSum.calculateSum(100);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCase8CalculateSum() {
        long expectedResult = 500 * 1001;
        long actualResult = NaturalNumberSum.calculateSum(1000);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
