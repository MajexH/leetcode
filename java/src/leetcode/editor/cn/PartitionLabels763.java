//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
//
// 
//
// 示例： 
//
// 
//输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 809 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionLabels763 {
    public static void main(String[] args) {
        Solution solution = new PartitionLabels763().new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final class Pair {
            private int start, end;

            public Pair(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public boolean interval(Pair last) {
                if (this.end > last.start) {
                    return true;
                }
                return false;
            }
        }

        public List<Integer> partitionLabels(String s) {
            Pair[] indexes = new Pair[26];

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (indexes[c - 'a'] == null) {
                    indexes[c - 'a'] = new Pair(i, i);
                    continue;
                }
                indexes[c - 'a'].end = i;
            }

            List<Integer> res = new ArrayList<>();
            // 开始排序
            List<Pair> intervals = Arrays.stream(indexes)
                    .filter(Objects::nonNull)
                    .sorted(Comparator.comparingInt(a -> a.start))
                    .collect(Collectors.toList());

            // 合并区间
            // 已经按照 start 排序 现在只需要直接合并
            Pair pre = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                // 如果相交
                if (pre.interval(intervals.get(i))) {
                    pre.end = Math.max(intervals.get(i).end, pre.end);
                    continue;
                }
                // 不想交
                res.add(pre.end - pre.start + 1);
                pre = intervals.get(i);
            }

            // 最后还要加上 pre
            res.add(pre.end - pre.start + 1);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}