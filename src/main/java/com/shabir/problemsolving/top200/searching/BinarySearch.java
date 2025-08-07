package com.shabir.problemsolving.top200.searching;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int lowerIndex = 0;
        int higherIndex = array.length - 1;
        while (lowerIndex <= higherIndex) {
            int midIndex = ((lowerIndex + higherIndex) / 2);
            if (array[midIndex] == target) {
                return midIndex;
            } else if (array[midIndex] < target) {
                lowerIndex = midIndex + 1;
            } else {
                higherIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
