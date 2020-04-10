import java.util.Arrays;
import java.util.Scanner;

// 这道题其实对应了一类dp问题
public class DPGetMax {

    /**
     * 今天上课，老师教了小易怎么计算加法和乘法，乘法的优先级大于加法，但是如果一个运算加了括号，那么它的优先级是最高的。例如：
     * 1+2*3=7
     * 1*(2+3)=5
     * 1*2*3=6
     * (1+2)*3=9
     * 现在小易希望你帮他计算给定3个数a，b，c，在它们中间添加"+"， "*"， "("， ")"符号，能够获得的最大值。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
        }

        // dp[i][j] 表示下标从 i 到 j 的nums组成的最大的值
        int[][] dp = new int[3][3];
        // 因为结果是 dp[0][2] 因此需要从后面开始构建
        for (int i = 2; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < 3; j++) {
                // k 作为 i j 之间的分割点
                for (int k = 0; i + k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][i + k] + dp[i + k + 1][j], dp[i][i + k] * dp[i + k + 1][j]));
                }

            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[0][2]);
    }
}
