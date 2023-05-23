//我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还
//会给出两个整数 numWanted 和 useLimit 。 
//
// 从 n 个元素中选择一个子集 s : 
//
// 
// 子集 s 的大小 小于或等于 numWanted 。 
// s 中 最多 有相同标签的 useLimit 项。 
// 
//
// 一个子集的 分数 是该子集的值之和。 
//
// 返回子集 s 的最大 分数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
//输出：9
//解释：选出的子集是第一项，第三项和第五项。
// 
//
// 示例 2： 
//
// 
//输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
//输出：12
//解释：选出的子集是第一项，第二项和第三项。
// 
//
// 示例 3： 
//
// 
//输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
//输出：16
//解释：选出的子集是第一项和第四项。
// 
//
// 
//
// 提示： 
//
// 
// n == values.length == labels.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= values[i], labels[i] <= 2 * 10⁴ 
// 1 <= numWanted, useLimit <= n 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 👍 50 👎 0


package src.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LargestValuesFromLabels_1090 {
    public static void main(String[] args) {
        Solution solution = new LargestValuesFromLabels_1090().new Solution();

        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1));
        System.out.println(solution.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 3, 3, 3, 2}, 3, 2));
        System.out.println(solution.largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1));

        System.out.println(solution.largestValsFromLabels(new int[]{2, 6, 3, 6, 5}, new int[]{1, 1, 2, 1, 1}, 3, 1));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {

            if (Objects.isNull(values) || values.length == 0) {
                return 0;
            }

            Pair[] valuePairs = new Pair[values.length];

            for (int i = 0; i < values.length; i++) {
                valuePairs[i] = new Pair(values[i], i);
            }

            // 从大到小进行排序
            Arrays.sort(valuePairs, (a, b) -> b.val - a.val);

            // 从大到小进行遍历
            int res = valuePairs[0].val;
            int numCounter = 1;

            Map<Integer, Integer> labelCountMap = new HashMap<>();
            labelCountMap.put(labels[valuePairs[0].index], 1);

            for (int i = 1; i < valuePairs.length; i++) {

                if (numCounter >= numWanted) {
                    break;
                }

                Pair pair = valuePairs[i];
                // 对应的 label
                int label = labels[pair.index];
                // 对应的 val
                int val = pair.val;

                int labelCount = labelCountMap.getOrDefault(label, 0);
                if (labelCount >= useLimit) {
                    continue;
                }
                res += val;
                numCounter++;
                labelCountMap.put(label, labelCount + 1);
            }

            return res;
        }

        private static final class Pair {
            int val;
            int index;

            public Pair(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}