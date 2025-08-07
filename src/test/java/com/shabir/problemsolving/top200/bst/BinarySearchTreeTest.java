package com.shabir.problemsolving.top200.bst;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void testCase1() {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree.Node root = tree.new Node(10);
        tree.root = root;
        root.left = tree.new Node(5);
        root.left.left = tree.new Node(2);
        root.left.left.left = tree.new Node(1);
        root.left.right = tree.new Node(5);
        root.right = tree.new Node(15);
        root.right.left = tree.new Node(13);
        root.right.left.right = tree.new Node(14);
        root.right.right = tree.new Node(22);

        tree.insert(12);
        Assertions.assertTrue(root.right.left.left.value == 12);

        tree.remove(10);
        Assertions.assertTrue(tree.contains(10) == false);
        Assertions.assertTrue(tree.root.value == 12);

        Assertions.assertTrue(tree.contains(15));
    }

}