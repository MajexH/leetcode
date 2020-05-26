import java.util.Arrays;

public class MaximumLengthofRepeatedSubarray_718 {

    public int findLength(int[] A, int[] B) {
        // dp[i][j] 表示以 A[i - 1] 结尾和以 B[j - 1] 结尾的数组的最长重复子数组长度
        int[][] dp = new int[A.length + 1][B.length + 1];
        // 保存遍历到的最大长度
        int res = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                // 这个地方不用判断不等于的情况 因为他要求的是 连续的子序列
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthofRepeatedSubarray_718().findLength(new int[]{ 0,1,1,1,1 }, new int[]{ 1,0,1,0,1 }));
    }
}
