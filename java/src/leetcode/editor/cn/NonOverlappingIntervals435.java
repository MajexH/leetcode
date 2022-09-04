//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重
//叠 。 
//
// 
//
// 示例 1: 
//
// 
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
// 
//
// 示例 2: 
//
// 
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
// 
//
// 示例 3: 
//
// 
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= intervals.length <= 10⁵ 
// intervals[i].length == 2 
// -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
// 
// Related Topics 贪心 数组 动态规划 排序 👍 781 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class NonOverlappingIntervals435 {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals435().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 这个问题可以转换成求最多有多少个区间不重复
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

            int right = intervals[0][1];
            int max = 1;

            for (int i = 1; i < intervals.length; i++) {
                // 如果不相交
                if (right <= intervals[i][0]) {
                    max++;
                    right = intervals[i][1];
                }
            }
            return intervals.length - max;
        }

        public int eraseOverlapIntervalsDP(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            });
            int[] dp = new int[intervals.length];
            Arrays.fill(dp, 1);
            int max = 0;
            for (int i = 0; i < intervals.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (!isInterval(intervals[j], intervals[i])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return intervals.length - max;
        }

        private boolean isInterval(int[] first, int[] second) {
            if (first[1] > second[0]) return true;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}