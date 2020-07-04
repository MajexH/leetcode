    import java.util.Arrays;

    public class PartitionParlindromIIAnother_132 {

        // 返回将 s 分割成一个回文子串需要的最少的分割次数
        public int minCut(String s) {
            // dp[i][j] 表示 i -> j 的字符串能否形成回文串
            boolean[][] dp = new boolean[s.length()][s.length()];
            // 一个数自己可以形成回文串
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && (i == j || j == i + 1 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }

            // min[i] 表示 0 - i 能够形成的最小划分
            int[] min = new int[s.length()];
            // 默认情况下 是没有不可能的
            Arrays.fill(min, Integer.MAX_VALUE);
            // 第一个数自己可以形成一个回文串 所以是 0
            min[0] = 0;
            for (int i = 1; i < s.length(); i++) {
                for (int j = 0; j <= i; j++) {
                    // 如果整个 j -> i 都是回文的
                    // 那就不需要划分
                    if (dp[j][i]) {
                        if (j == 0) {
                            min[i] = 0;
                            break;
                        } else {
                            // 不然就需要找到里面 最小的划分
                            min[i] = Math.min(min[i], min[j - 1] + 1);
                        }
                    }
                }
            }

            return min[s.length() - 1];
        }

        public static void main(String[] args) {
            System.out.println(new PartitionParlindromIIAnother_132().minCut("aab"));
        }
    }
