package com.shabir.problemsolving.top200.bst;

/*Write a function that takes in a Binary Search Tree (BST) and a target integer
value and returns the closest value to that target value contained in the BST.

You can assume that there will only be one closest value.

Each BST node has an integer value, a left child node, and a right child node.
A node is said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid BST nodes themselves or None/null.

Sample Input:
          10
        /     \
        5      15
        /   \   /   \
        2     5 13   22
        /           \
        1            14

Sample Output: 13*/


// Average: O(logn) time | O(1) space
// Worst case when the tree becomes a sequential list: O(n) time | O(1) space


public class FindClosestValueInBST {

    static class BSTNode {
        public BSTNode left;
        public BSTNode right;
        public int value;

        BSTNode(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BSTNode root, int target) {
        int minDiff = Integer.MAX_VALUE;
        int closestValue = 0;

        while (root != null) {
            int currentDiff = root.value > target ? root.value - target : target - root.value;
            if (currentDiff == 0) {
                minDiff = currentDiff;
                closestValue = root.value;
                break;
            }
            minDiff = currentDiff < minDiff ? currentDiff : minDiff;
            closestValue = currentDiff == minDiff ? root.value : closestValue;
            root = target < root.value ? root.left : root.right;
        }
        return closestValue;
    }

    public static int findClosestValueInBstUsingRecursion(BSTNode root, int target) {
        return findClosestValue(root, target);
    }

    private static int findClosestValue(BSTNode root, int target) {
        int closestValue = 0;
        if (target > root.value && root.right != null) {
            closestValue = findClosestValue(root.right, target);
        } else if (target < root.value && root.left != null) {
            closestValue = findClosestValue(root.left, target);
        } else {
            closestValue = root.value;
        }
        int diff1 = target > root.value ? target - root.value : root.value - target;
        int diff2 = target > closestValue ? target - closestValue : closestValue - target;
        return diff1 < diff2 ? root.value : closestValue;
    }

}