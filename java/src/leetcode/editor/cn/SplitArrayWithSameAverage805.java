//给定你一个整数数组
// nums 
//
// 我们要将
// nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和
// B 数组不为空，并且
// average(A) == average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组
// arr , 
// average(arr) 是
// arr 的所有元素除以
// arr 长度的和。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 位运算 数组 数学 动态规划 状态压缩 👍 164 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SplitArrayWithSameAverage805 {
    public static void main(String[] args) {
        Solution solution = new SplitArrayWithSameAverage805().new Solution();
        System.out.println(solution.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution.splitArraySameAverage(new int[]{3, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean splitArraySameAverage(int[] nums) {
            // 可以通过简单的数据推理得到 average(A) == average(B) == average(nums)
            // 那么其结果就是去求 找到一个数组 A  sum(A) = nums(A) * average(nums)

            // 求平均值
            int sum = Arrays.stream(nums).sum();

            Arrays.sort(nums);

            // 因为有分两个数组 那么有一个数组一定是小于一半的
            // 那么如果小的数组满足要求 大的数据也满足要求
            for (int len = nums.length / 2; len >= 1; len--) {
                // sum(A) * n == sum(nums) * size(A)
                // 那么 sum(nums) * size(A) 一定能被 n 整除
                // 遍历 size(A) 看是否可行 进行剪枝
                if (sum * len % nums.length == 0
                        && this.dfs(nums, len, 0, sum, 0, 0)) {
                    return true;
                }
            }

            return false;
        }

        private boolean dfs(int[] nums, int len, int start, int sum, int lenA, int sumA) {
            if (lenA == len) {
                if ((double) sum / nums.length == (double) sumA / lenA) {
                    return true;
                }
                return false;
            }

            for (int i = start; i < nums.length; i++) {
                sumA += nums[i];
                lenA += 1;
                if (this.dfs(nums, len, i + 1, sum, lenA, sumA)) {
                    return true;
                }
                sumA -= nums[i];
                lenA -= 1;
                //如果下一个值和当前计算失败的值相同的话 就跳过
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i++;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}