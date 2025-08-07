package com.shabir.problemsolving.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumber {

    public static void main(String... args) {
        int[] inputArray = {-1, -3, 2, 0, -4, 6, 3, 1, 5, 4, 10, 2, 0, -3, -1};
        int kthSmallestNumber = findKthSmallestNumber(inputArray, 6);
        System.out.println(kthSmallestNumber);
    }

    public static int findKthSmallestNumber(int[] inputArray, int k) {
        return execute(inputArray, k);
    }

    private static int execute(int[] inputArray, int k) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(k, (n1, n2) -> -n1.compareTo(n2));
        for (int number : inputArray) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(number);
                continue;
            }
            if (number >= priorityQueue.peek()) {
                continue;
            }
            priorityQueue.poll();
            priorityQueue.offer(number);
        }
        return priorityQueue.peek();
    }

}
