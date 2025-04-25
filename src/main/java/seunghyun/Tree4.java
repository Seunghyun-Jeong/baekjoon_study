package seunghyun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree4 {
    private static List<Node>[] tree;

    private static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (1 > N || N > 26) {
            throw new IllegalArgumentException();
        }
        sc.nextLine();

        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            int root = input[0].charAt(0) - 'A';
            int left = input[1].charAt(0) == '.' ? -1 : input[1].charAt(0) - 'A';
            int right = input[2].charAt(0) == '.' ? -1 : input[2].charAt(0) - 'A';

            tree[root].add(new Node(left, right));
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
        System.out.println();
    }

    private static void preorder(int start) {
        for (Node n : tree[start]) {
            int left = n.left;
            int right = n.right;

            System.out.print((char) (start + 'A'));

            if (left != -1) {
                preorder(left);
            }
            if (right != -1) {
                preorder(right);
            }
        }
    }

    private static void inorder(int start) {
        for (Node n : tree[start]) {
            int left = n.left;
            int right = n.right;

            if (left != -1) {
                inorder(left);
            }
            System.out.print((char) (start + 'A'));
            if (right != -1) {
                inorder(right);
            }
        }
    }

    private static void postorder(int start) {
        for (Node n : tree[start]) {
            int left = n.left;
            int right = n.right;

            if (left != -1) {
                postorder(left);
            }
            if (right != -1) {
                postorder(right);
            }
            System.out.print((char) (start + 'A'));
        }
    }
}