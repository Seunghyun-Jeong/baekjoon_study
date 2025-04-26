package seunghyun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tree5 {
    private static int[] inorder, postorder;
    private static Map<Integer, Integer> inorderIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (1 > n || n > 100000) {
            throw new IllegalArgumentException();
        }

        inorder = new int[n];
        postorder = new int[n];
        inorderIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            inorderIndex.put(inorder[i], i);
        }

        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }

        getPreorder(0, n - 1, 0, n - 1);
    }

    private static void getPreorder(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return;
        }

        int root = postorder[postorderEnd];
        System.out.print(root + " ");

        int rootIndex = inorderIndex.get(root);
        int leftSize = rootIndex - inorderStart;
        getPreorder(inorderStart, rootIndex - 1, postorderStart, postorderStart + leftSize - 1);
        getPreorder(rootIndex + 1, inorderEnd, postorderStart + leftSize, postorderEnd - 1);
    }
}