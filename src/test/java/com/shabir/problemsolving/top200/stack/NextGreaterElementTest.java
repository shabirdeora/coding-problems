package com.shabir.problemsolving.top200.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NextGreaterElementTest {

    @Test
    public void testCase1() {
        int[] input = new int[] {2, 5, -3, -4, 6, 7, 2};
        int[] expected = new int[] {5, 6, 6, 6, 7, -1, 5};
        int[] actual = NextGreaterElement.nextGreaterElement(input);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], actual[i]);
        }
    }

}