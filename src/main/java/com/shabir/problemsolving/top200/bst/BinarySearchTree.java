package com.shabir.problemsolving.top200.bst;

public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space
    public Node insert(int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        Node currentNode = root;
        while (true) {
            if (value < currentNode.value) {
                if (currentNode.left != null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new Node(value);
                    break;
                }
            } else {
                if (currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new Node(value);
                    break;
                }
            }
        }
        return root;
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space
    public boolean contains(int value) {
        Node currentNode = root;
        while(currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
        }
        return false;
    }

    // Average: O(log(n)) time | O(1) space
    // Worst: O(n) time | O(1) space
    public Node remove(int value) {
        return remove(value, root);
    }

    private Node remove(int value, Node root) {
        Node parentNode = root;
        if (parentNode == null) {
            return null;
        }
        if (parentNode.left == null && parentNode.right == null) {
            if (value == parentNode.value) {
                parentNode = null;
            }
            return parentNode;
        }
        Node currentNode = parentNode;
        while (currentNode != null) {
            if (value == currentNode.value) {
                if (currentNode.left != null && currentNode.right != null) {
                    currentNode.value = findMinimum(currentNode.right);
                    currentNode.right = remove(currentNode.value, currentNode.right);
                    break;
                } else if (currentNode.left != null) {
                    if (currentNode == parentNode) {
                        currentNode = currentNode.left;
                        parentNode.value = currentNode.value;
                        parentNode.left = currentNode.left;
                        parentNode.right = currentNode.right;
                    } else if (currentNode == parentNode.left) {
                        parentNode.left = currentNode.left;
                    } else {
                        parentNode.right = currentNode.left;
                    }
                } else {
                    if (currentNode == parentNode) {
                        currentNode = currentNode.right;
                        parentNode.value = currentNode.value;
                        parentNode.left = currentNode.left;
                        parentNode.right = currentNode.right;
                    } else if (currentNode == parentNode.left) {
                        parentNode.left = currentNode.right;
                    } else {
                        parentNode.right = currentNode.right;
                    }
                }
                currentNode.left = null;
                currentNode.right = null;
                currentNode = null;
            } else {
                parentNode = currentNode;
                currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
            }
        }
        return root;
    }

    private int findMinimum(Node root) {
        Node currentNode = root;
        while(currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

}
