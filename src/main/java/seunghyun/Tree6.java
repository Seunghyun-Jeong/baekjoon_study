package seunghyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree6 {
    private static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> preorder = new ArrayList<>();

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (1 > n || n > 1000000) {
                throw new IllegalArgumentException();
            }
            preorder.add(n);
        }

        if (preorder.isEmpty()) {
            return;
        }

        Node root = BST(preorder);
        postorder(root);
    }

    private static Node BST(List<Integer> preorder) {
        Node root = new Node(preorder.get(0));

        for (int i = 1; i < preorder.size(); i++) {
            insert(root, preorder.get(i));
        }
        return root;
    }

    private static void insert(Node root, int key) {
        if (root.key > key) {
            if (root.left == null) {
                root.left = new Node(key);
            } else {
                insert(root.left, key);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(key);
            } else {
                insert(root.right, key);
            }
        }
    }

    private static void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.key);
    }
}