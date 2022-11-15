//请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi,
//numberOfUnitsPerBoxi] ： 
//
// 
// numberOfBoxesi 是类型 i 的箱子的数量。 
// numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。 
// 
//
// 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。 
//
// 返回卡车可以装载 单元 的 最大 总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//输出：8
//解释：箱子的情况如下：
//- 1 个第一类的箱子，里面含 3 个单元。
//- 2 个第二类的箱子，每个里面含 2 个单元。
//- 3 个第三类的箱子，每个里面含 1 个单元。
//可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
//单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8 
//
// 示例 2： 
//
// 
//输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//输出：91
// 
//
// 
//
// 提示： 
//
// 
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 10⁶ 
// 
//
// Related Topics 贪心 数组 排序 👍 75 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class MaximumUnitsOnATruck1710 {
    public static void main(String[] args) {
        Solution solution = new MaximumUnitsOnATruck1710().new Solution();
        System.out.println(solution.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        System.out.println(solution.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumUnits(int[][] boxTypes, int truckSize) {

            // 贪心
            // 先装价值大的 那么所以就要先把价值大的放进去
            Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

            int res = 0;

            for (int[] boxType : boxTypes) {
                if (truckSize >= boxType[0]) {
                    truckSize -= boxType[0];
                    res += boxType[0] * boxType[1];
                } else {
                    // 这个时候就小于了 就只能加上 truckSize 个了
                    res += truckSize * boxType[1];
                    break;
                }
            }

            return res;
        }

        public int maximumUnitsWithDp(int[][] boxTypes, int truckSize) {

            int[] dp = new int[truckSize + 1];

            for (int[] boxType : boxTypes) {
                for (int i = truckSize; i >= 0; i--) {
                    // 尝试装进去
                    // 尝试每个大小的盒子都装进去
                    for (int j = 1; j <= boxType[0]; j++) {
                        if (i >= j) {
                            dp[i] = Math.max(dp[i], dp[i - j] + j * boxType[1]);
                        } else {
                            dp[i] = Math.max(dp[i], dp[0] + i * boxType[1]);
                            break;
                        }
                    }

                }
            }

            return dp[truckSize];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}