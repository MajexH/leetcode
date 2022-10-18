//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
//
// Related Topics 位运算 数组 哈希表 👍 187 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MissingTwoLcci_17_19 {

    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci_17_19().new Solution();
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{1})));
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{2, 3})));
        System.out.println(Arrays.toString(solution.missingTwo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final Integer BUCKET_SIZE = 1000;

        public int[] missingTwo(int[] nums) {
            // 桶排序
            // 每个桶里面依次保存  1-64 65-128 129-192
            int[] buckets = new int[BUCKET_SIZE];

            for (int num : nums) {
                int bucketIndex = this.getBucketIndex(num);
                buckets[bucketIndex] |= (1 << this.getNumIndex(num));
            }

            int[] res = new int[2];
            int index = 0;

            for (int i = 1; i <= nums.length + 2; i++) {
                int bucket = buckets[this.getBucketIndex(i)];
                if (((bucket >> this.getNumIndex(i)) & 1) == 0) {
                    res[index++] = i;
                    if (index == 2) {
                        break;
                    }
                }
            }

            return res;
        }

        private Integer getBucketIndex(int num) {
            return num / 32;
        }

        private Integer getNumIndex(int num) {
            return num % 32;
        }

        private Integer getNumber(int bucketIndex, int index) {
            return bucketIndex * 32 + index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}