package com.shabir.problemsolving.top200.stack;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement {

    private static List<Integer> stack = new ArrayList<>();
    private static int top = -1;

    // All case: O(n) time | O(n) space
    public static int[] nextGreaterElement(int[] input) {
        int[] output = new int[input.length];
        for (int index = 0; index < input.length; index++) {
            while (!isStackEmpty()) {
                if (input[peek()] >= input[index]) {
                    break;
                }
                output[pop()] = input[index];
            }
            push(index);
        }
        if (!isStackEmpty()) {
            for (int index = 0; index < input.length; index++) {
                while (!isStackEmpty()) {
                    if (input[peek()] >= input[index]) {
                        break;
                    }
                    output[pop()] = input[index];
                }
                if (isStackEmpty()) {
                    break;
                }
            }
        }
        if (!isStackEmpty()) {
            while (!isStackEmpty()) {
                output[pop()] = -1;
            }
        }
        return output;
    }

    private static boolean isStackEmpty() {
        return top == -1;
    }

    private static Integer pop() {
        if (isStackEmpty()) {
            return null;
        }
        return stack.remove(top--);
    }

    private static Integer peek() {
        if (isStackEmpty()) {
            return null;
        }
        return stack.get(top);
    }

    private static void push(int item) {
        stack.add(item);
        top++;
    }
}
