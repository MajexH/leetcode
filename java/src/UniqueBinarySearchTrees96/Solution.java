package UniqueBinarySearchTrees96;

import java.util.Arrays;

public class Solution {

    // 实际上就是用一个数字当root 问左右子树能形成几个BST
    // 其实状态转移方程有点类似于 dp[i] = dp[i - 1] * dp[n - i] 因为组合 所以是乘法
    public int numTrees(int n) {
        // without memo
        // return recursion(n);
        // with memo
//        int[] memo = new int[n + 1];
//        return recursionWithMemo(n, memo);
        return dpLoop(n);
    }

    public int recursion(int n) {
        if (n <= 1) return 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            // 这个地方可以用n-i的原因是 1 2两个数字和可以组成的BST和 2 3两个数字可以组成的BST的数量是一样的
            sum += recursion(i - 1) * recursion(n - i);
        }
        return sum;
    }

    public int recursionWithMemo(int n, int[] memo) {
        if (n <= 1) {
            memo[n] = 1;
            return 1;
        }
        if (memo[n] != 0) return memo[n];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += recursionWithMemo(i - 1, memo) * recursionWithMemo(n - i, memo);
        }
        memo[n] = sum;
        return memo[n];
    }

    public int dpLoop(int n) {
        // dp 表示在数字的最大值为n的时候 能够生成的BST的数量
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;
        // 总的数字的数量
        for (int i = 2; i <= n; i++) {
            // 这个就是recursion里面 计算每个的方法 就是选一个数出来做root
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().dpLoop(3));
    }
}
