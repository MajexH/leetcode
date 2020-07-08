import java.util.Arrays;

public class NotSortedArrayLongestSubWithGivenSum {

    /**
     * 给定一个无序的正数数组 nums，求 nums 的所有子数组中，
     * 所有元素之和为 target 的最长子数组的长度
     * 我这个版本考虑的是 这个子数组 可以由里面的任意数字组成
     * 例如 nums = [1,3,1,1,1,1], k = 4
     * 则最长子数组为 1,1,1,1 结果返回 4
     * @param nums 输入的全为正数的无序数组
     * @param target 需要的和
     * @return 返回和为 target 的最长子数组的长度
     */
    public int getLongestSubLength(int[] nums, int target) {
        // dp[i][j] 表示选取 nums[i] 作为结尾的和为 j 的 子数组长度为多少
        int[][] dp = new int[nums.length][target + 1];
        int res = 0;
        // 最外层循环是遍历 target 值
        for (int targetTemp = 0; targetTemp <= target; targetTemp++) {
            for (int i = 0; i < nums.length; i++) {
                // 因为是选取 nums[i] 作为结尾
                // 所以只需要寻找子数组和为 targetTemp - nums[i] 的长度
                int findTarget = targetTemp - nums[i];
                // 因为全为正数 所以不可能回去寻找负数
                if (findTarget < 0) continue;
                // 因为不包括 i 所以不遍历 i
                int max = 0;
                for (int j = 0; j < i; j++) {
                    max = Math.max(max, dp[j][findTarget]);
                }
                dp[i][targetTemp] = max + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i][target]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NotSortedArrayLongestSubWithGivenSum().getLongestSubLength(new int[]{ 1,1,1,3,1,1,1 }, 2));
    }
}
