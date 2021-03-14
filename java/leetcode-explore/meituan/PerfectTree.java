package meituan;

import java.util.Scanner;

public class PerfectTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] inorder = new int[n];
        for (int i = 0; i < inorder.length; i++) {
            inorder[i] = sc.nextInt();
        }

        int[][] min = new int[n][n];

        for (int i = 0; i < n; i++) {
            min[i][i] = inorder[i];
            for (int j = i + 1; j < n; j++) {
                min[i][j] = Math.min(min[i][j - 1], inorder[j]);
            }
        }

        System.out.println();
    }


    private static int recursion(int[][] min, int rootIndex, int left, int right) {
    return -1;
    }
}
