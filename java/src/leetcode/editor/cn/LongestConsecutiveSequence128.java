//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 并查集 数组 哈希表 👍 1306 👎 0


package src.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence128 {
  public static void main(String[] args) {
       Solution solution = new LongestConsecutiveSequence128().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        Set<Integer> traveled = new HashSet<>();
        int res = 0;

        for (int num : nums) {
            if (traveled.contains(num)) {
                continue;
            }

            int tmp = 1;
            traveled.add(num);

            int minus = num;
            while (set.contains(minus - 1)) {
                tmp++;
                traveled.add(minus);
                minus--;
            }

            int bigger = num;
            while (set.contains(bigger + 1)) {
                tmp++;
                traveled.add(bigger);
                bigger++;
            }
            res = Math.max(tmp, res);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}