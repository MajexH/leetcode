//给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。 
//
// 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,5,1,3,4,7], n = 3
//输出：[2,3,5,4,1,7] 
//解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,4,3,2,1], n = 4
//输出：[1,4,2,3,3,2,4,1]
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,2,2], n = 2
//输出：[1,2,1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// nums.length == 2n 
// 1 <= nums[i] <= 10^3 
// 
// Related Topics 数组 👍 126 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class ShuffleTheArray1470 {
    public static void main(String[] args) {
        Solution solution = new ShuffleTheArray1470().new Solution();
        System.out.println(Arrays.toString(solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // in place 方法
        // 因为最大的数据是 10^3 所以 可以最大就是 10 位的长度 可以把剩下的 22 位来存储交换过来的数据
        public int[] shuffle(int[] nums, int n) {

            for (int i = 0; i < nums.length; i++) {
                // 偶数
                if ((i & 1) == 0) {
                    // 新的 i 的下标 对应原来的 2 * i 位置的数据
                    nums[i] = this.getCombineNumber(this.getLowTenBitNumber(nums[i / 2]), nums[i]);
                } else {
                    // 奇数
                    // 新的 i + 1 的下标 对应原来的 n + i / 2 位置的数据
                    // 存储在 新的位置的 10 -> 19 位置上
                    nums[i] = this.getCombineNumber(this.getLowTenBitNumber(nums[n + i / 2]), nums[i]);
                }

            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] >>= 10;
            }

            return nums;
        }

        // 组合老数据 和 位置上的新数据
        // 将 newNumber 组装到 oldNumber 的 10 —> 19 位上
        private int getCombineNumber(int newNum, int oldNum) {
            return (newNum << 10) | oldNum;
        }

        private int getLowTenBitNumber(int num) {
            // 1023 = 1024 - 1(XXX00001111111111)
            return num & 1023;
        }

        public int[] shuffleRude(int[] nums, int n) {
            int[] res = new int[nums.length];

            for (int i = 0, odd = 0, even = n; i < nums.length; i++) {
                // 偶数
                if ((i & 1) == 0) {
                    res[i] = nums[odd++];
                } else {
                    res[i] = nums[even++];
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}