public class OnesAndZeros_474 {

    class Pair {
        public int ones = 0;
        public int zeros = 0;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // 表示m个0和n个1  可以形成的str的数量的最大值
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            Pair temp = getPair(str);
            // 这儿必须从后往前构建 因为会有重复
            // 重复是怎么来的 重复是因为 从前往后 当前字符串 会因为  dp[i - temp.zeros][j - temp.ones] 而重复计算
            for (int i = m; i >= temp.zeros; i--) {
                for (int j = n; j >= temp.ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - temp.zeros][j - temp.ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public Pair getPair(String str) {
        Pair temp = new Pair();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                temp.zeros++;
            } else {
                temp.ones++;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new OnesAndZeros_474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
