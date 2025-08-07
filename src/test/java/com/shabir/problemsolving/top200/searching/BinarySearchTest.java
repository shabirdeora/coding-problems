package com.shabir.problemsolving.top200.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

    @Test
    public void testCase1() {
        Assertions.assertTrue(BinarySearch.binarySearch(new int[] {0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33) == 3);
    }

}