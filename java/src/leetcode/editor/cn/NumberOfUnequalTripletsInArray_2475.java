//给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
//
// 
// 0 <= i < j < k < nums.length 
// nums[i]、nums[j] 和 nums[k] 两两不同 。 
// 
// 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。 
// 
// 
//
// 返回满足上述条件三元组的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,4,2,4,3]
//输出：3
//解释：下面列出的三元组均满足题目条件：
//- (0, 2, 4) 因为 4 != 2 != 3
//- (1, 2, 4) 因为 4 != 2 != 3
//- (2, 3, 4) 因为 2 != 4 != 3
//共计 3 个三元组，返回 3 。
//注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,1,1]
//输出：0
//解释：不存在满足条件的三元组，所以返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 100 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 👍 55 👎 0


package src.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberOfUnequalTripletsInArray_2475 {
    public static void main(String[] args) {
        Solution solution = new NumberOfUnequalTripletsInArray_2475().new Solution();
        System.out.println(solution.unequalTriplets(new int[]{4, 4, 2, 4, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final class Holder {
            int[] indexes;

            public Holder(int[] indexes) {
                this.indexes = indexes;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Holder holder = (Holder) o;
                return Arrays.equals(indexes, holder.indexes);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(indexes);
            }
        }

        public int unequalTriplets(int[] nums) {

            if (Objects.isNull(nums) || nums.length < 3) {
                return 0;
            }

            Set<Holder> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                int first = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    int second = nums[j];
                    for (int k = j + 1; k < nums.length; k++) {
                        int third = nums[k];
                        if (first != second && first != third && second != third) {
                            set.add(new Holder(new int[]{i, j, k}));
                        }
                    }
                }
            }

            return set.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}