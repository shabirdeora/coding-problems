package com.shabir.problemsolving.top200.bst;

import org.junit.jupiter.api.*;

public class FindClosestValueInBSTTest {

    private FindClosestValueInBST.BSTNode root;

    @BeforeAll
    public static void start() {

    }

    @BeforeEach
    public void initialize() {
        root = new FindClosestValueInBST.BSTNode(10);
        root.left = new FindClosestValueInBST.BSTNode(5);
        root.left.left = new FindClosestValueInBST.BSTNode(2);
        root.left.left.left = new FindClosestValueInBST.BSTNode(1);
        root.left.right = new FindClosestValueInBST.BSTNode(5);
        root.right = new FindClosestValueInBST.BSTNode(15);
        root.right.left = new FindClosestValueInBST.BSTNode(13);
        root.right.left.right = new FindClosestValueInBST.BSTNode(14);
        root.right.right = new FindClosestValueInBST.BSTNode(22);
    }

    @Test
    public void testCase1() {
        int expected = 13;
        int actual = FindClosestValueInBST.findClosestValueInBst(root, 12);
        System.out.println("Result = " + actual);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCase2() {
        int expected = 13;
        int actual = FindClosestValueInBST.findClosestValueInBstUsingRecursion(root, 12);
        System.out.println("Result = " + actual);
        Assertions.assertEquals(expected, actual);
    }

    @AfterEach
    public void destroy() {
        root = null;
    }

    @AfterAll
    public static void shutdown() {

    }

}