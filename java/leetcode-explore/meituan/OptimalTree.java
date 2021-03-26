package meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OptimalTree {

    static int[][][] mem;
    static int[] weight;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        String[] strW = br.readLine().trim().split(" ");
        weight = new int[n];
        for(int i = 0; i < n; i++) weight[i] = Integer.parseInt(strW[i]);
        // mem[l][r][k]表示以weight[l:r]为子节点，以weight[k]为根节点的树开销
        mem = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++) mem[i][j][k] = -1;
        }
        System.out.println(recur(0, n - 1, -1));
    }

    private static int recur(int left, int right, int root) {
        if(left > right) return 0;
        if(root >= 0 && mem[left][right][root] != -1) return mem[left][right][root];
        int cost = Integer.MAX_VALUE;
        // [left,right]中的元素轮流做根节点构建二叉树
        int leftCost = 0, rightCost = 0;
        for(int i = left; i <= right; i++){
            leftCost = recur(left, i - 1, i);      // 左子树开销
            rightCost = recur(i + 1, right, i);    // 右子树开销
            // root=-1时表示初始根节点还没有确定，不会有根节点连接左右子树的边
            cost = Math.min(cost, leftCost + rightCost + weight[i]*(root != -1? weight[root]: 0));
        }
        if(root >= 0) mem[left][right][root] = cost;
        return cost;
    }
}
