package leetcode.editor.cn;//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 👍 610 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MajorityElementIi229 {
    public static void main(String[] args) {
        Solution solution = new MajorityElementIi229().new Solution();
        System.out.println(solution.majorityElement(new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            if (Objects.isNull(nums)) {
                return new ArrayList<>();
            }

            int num1 = nums[0], num2 = nums[0];
            int count1 = 0, count2 = 0;

            for (int num : nums) {
                if (num1 == num) {
                    count1++;
                } else if (num2 == num) {
                    count2++;
                } else if (count1 == 0) {
                    num1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    num2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }

            count1 = 0;
            count2 = 0;

            for (int num : nums) {
                if (num == num1) {
                    count1++;
                } else if (num == num2) {
                    count2++;
                }
            }

            List<Integer> res = new ArrayList<>();
            if (count1 > nums.length / 3) {
                res.add(num1);
            }
            if (count2 > nums.length / 3) {
                res.add(num2);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}