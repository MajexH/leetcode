//给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
//
// 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
//输出：1
//解释：存在一对相等行列对：
//- (第 2 行，第 1 列)：[2,7,7]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
//输出：3
//解释：存在三对相等行列对：
//- (第 0 行，第 0 列)：[3,1,2,2]
//- (第 2 行, 第 2 列)：[2,4,2,2]
//- (第 3 行, 第 2 列)：[2,4,2,2]
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// 1 <= grid[i][j] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 矩阵 模拟 👍 37 👎 0


package src.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs_2352 {

    public static void main(String[] args) {
        Solution solution = new EqualRowAndColumnPairs_2352().new Solution();

        System.out.println(solution.equalPairs(new int[][]{
                {3, 2, 1}, {1, 7, 6}, {2, 7, 7}
        }));

        System.out.println(solution.equalPairs(new int[][]{
                {3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}
        }));
        System.out.println(solution.equalPairs(new int[][]{
                {13, 13}, {13, 13}
        }));
        System.out.println(solution.equalPairs(new int[][]{
                {2, 1}, {3, 32}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int equalPairs(int[][] grid) {

            Map<Holder, Integer> rowCounterMap = new HashMap<>();

            // 就是 hash 表
            // 先扫描 横行
            for (int i = 0; i < grid.length; i++) {
                Holder holder = new Holder(grid[i]);
                rowCounterMap.put(holder, rowCounterMap.getOrDefault(holder, 0) + 1);
            }

            int res = 0;
            // 再扫描列
            for (int j = 0; j < grid[0].length; j++) {
                int[] tmp = new int[grid.length];
                for (int i = 0; i < grid.length; i++) {
                    tmp[i] = grid[i][j];
                }
                Holder holder = new Holder(tmp);

                if (!rowCounterMap.containsKey(holder)) {
                    continue;
                }

                res += rowCounterMap.get(holder);
            }

            return res;
        }

        public static final class Holder {
            int[] val;

            public Holder(int[] val) {
                this.val = val;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Holder holder = (Holder) o;
                return Arrays.equals(val, holder.val);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(val);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}