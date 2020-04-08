import java.util.Arrays;

public class OnesAndZeroes_474 {

    class Pair {
        public int zeros = 0;
        public int ones = 0;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 表示 i 个0 j 个1 能够构成的数字的最大长度
        int[][] dp = new int[m + 1][n + 1];
        // 必须把str的循环放在外面 因为里面这样可以一层一层构建dp
        // 当去循环下个str的时候 里面的dp已经构建完成一次 这样才可以说 要或者不要
        for (String str : strs) {
            Pair res = findZerosAndOnes(str);
            for (int i = m; i >= res.zeros; i--) {
                for (int j = n; j >= res.ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - res.zeros][j - res.ones] + 1);
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m][n];
    }

    public Pair findZerosAndOnes(String str) {
        Pair res = new Pair();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') res.zeros++;
            else if (str.charAt(i) == '1') res.ones++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new OnesAndZeroes_474().findMaxForm(new String[]{"1", "0", "0001", "111001", "10"}, 5, 3));
    }
}
