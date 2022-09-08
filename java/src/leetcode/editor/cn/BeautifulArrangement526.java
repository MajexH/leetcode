//假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ： 
//
// 
// perm[i] 能够被 i 整除 
// i 能够被 perm[i] 整除 
// 
//
// 给你一个整数 n ，返回可以构造的 优美排列 的 数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：
//第 1 个优美的排列是 [1,2]：
//    - perm[1] = 1 能被 i = 1 整除
//    - perm[2] = 2 能被 i = 2 整除
//第 2 个优美的排列是 [2,1]:
//    - perm[1] = 2 能被 i = 1 整除
//    - i = 2 能被 perm[2] = 1 整除
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 15 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 325 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement526 {
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangement526().new Solution();
        System.out.println(solution.countArrangement(2));
        System.out.println(solution.countArrangement(3));
        System.out.println(solution.countArrangement(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int res = 0;

        public void recursion(List<Integer>[] tmp, boolean[] visited, int n, int index) {
            if (index > n) {
                this.res++;
                return;
            }

            for (int num : tmp[index]) {
                if (!visited[num]) {
                    visited[num] = true;
                    this.recursion(tmp, visited, n, index + 1);
                    visited[num] = false;
                }
            }
        }

        public int countArrangement(int n) {
            this.res = 0;
            List<Integer>[] nums = new ArrayList[n + 1];
            boolean[] visited = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                nums[i] = new ArrayList<Integer>();
                for (int j = 1; j <= n; j++) {
                    if (i % j == 0 || j % i == 0) {
                        nums[i].add(j);
                    }
                }
            }

            this.recursion(nums, visited, n, 1);
            return this.res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}