import java.util.Arrays;
import java.util.HashMap;

public class LongestArithmeticSequence_1027_needSequence {

    // 找到这个等差数列的话 需要在意它的顺序
    public int longestArithSeqLength(int[] A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int maxDiff = max - min;
        // dp[i][j] 表示 以 A[i] 结尾的数 等差为j的长度是多少
        // 因为可能存在负数 因此 用两倍 原来的0的位置就在 maxDiff处
        int[][] dp = new int[A.length][2 * maxDiff + 1];
        for (int i = 0; i < A.length; i++) {
            // 任何数和自己做等差数列的长度都是1
            Arrays.fill(dp[i], 1);
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][A[i] - A[j] + maxDiff] = dp[j][A[i] - A[j] + maxDiff] + 1;
                res = Math.max(res, dp[i][A[i] - A[j] + maxDiff]);
            }
        }
//        for (int i = 0; i < A.length; i++) {
//            // 任何数和自己做等差数列的长度都是1
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return res;
    }

    // 实际上这个想法是相同的 就是他用的是hashmap来保存前面的 等差数列的 等差和值
    // 如果上面爆堆了 可以是使用这个
    public int longestArithSeqLength1(int[] A) {
        int res = 2, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestArithmeticSequence_1027_needSequence().longestArithSeqLength(new int[]{ 0,8,45,88,48,68,28,55,17,24 }));
    }
}
