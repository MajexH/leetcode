import java.util.HashMap;
import java.util.Map;

public class FindMaxForm_474 {

    // 这个方法使用 dp 来压缩搜搜的过程
    public int findMaxForm(String[] strs, int m, int n) {
        // 背包问题 dp[i][j] 表示 i 个 0 n 个 1 可以组成的大小
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int zero = countZeros(str), one = str.length() - zero;
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }

    // 直接模拟选或者不选这个地方 然后构建一颗二叉树进行选择
    public int findMaxFormBruteForce(String[] strs, int m, int n) {
        int[] zeros = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            zeros[i] = countZeros(strs[i]);
        }
        return recursion(zeros, strs, m, n, 0, 0, new HashMap<>());
    }

    private int recursion(int[] zeros, String[] strs, int m, int n, int index, int tmp, Map<String, Integer> memo) {
        if (index >= strs.length) {
            return 0;
        }
        String key = String.format("%d-%d-%d", index, m, n);
        if (memo.containsKey(key)) return memo.get(key);

        int zero = zeros[index], ones = strs[index].length() - zero;
        int choose = 0, notChoose;
        if (m >= zero && n >= ones) {
            choose = recursion(zeros, strs, m - zero, n - ones, index + 1, tmp + 1, memo) + 1;
        }
        notChoose = recursion(zeros, strs, m, n, index + 1, tmp, memo);
        memo.put(key, Math.max(choose, notChoose));
        return memo.get(key);
    }

    private int countZeros(String str) {
        int zeros = 0;

        for (char c :str.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }
}
