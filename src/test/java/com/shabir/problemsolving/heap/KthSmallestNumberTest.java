package com.shabir.problemsolving.heap;

import org.junit.jupiter.api.*;

public class KthSmallestNumberTest {

    @BeforeAll
    public static void start() {

    }

    @Test
    public void testFindKthSmallestNumber() {
        int[] inputArray = {-1, -3, 2, 0, -4, 6, 3, 1, 5, 4, 10, 2, 0, -3, -1};
        int k = 6;
        int expectedResult = 0;
        int actualResult = KthSmallestNumber.findKthSmallestNumber(inputArray, k);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @BeforeEach
    public void initialize() {

    }

    @AfterEach
    public void destroy() {

    }

    @AfterAll
    public static void shutdown() {

    }

}