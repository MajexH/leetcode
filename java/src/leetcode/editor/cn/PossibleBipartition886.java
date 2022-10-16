//<p>给定一组&nbsp;<code>n</code>&nbsp;人（编号为&nbsp;<code>1, 2, ..., n</code>），&nbsp;我们想把每个人分进<strong>任意</strong>大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。</p>
//
//<p>给定整数 <code>n</code>&nbsp;和数组 <code>dislikes</code>&nbsp;，其中&nbsp;<code>dislikes[i] = [a<sub>i</sub>, b<sub>i</sub>]</code>&nbsp;，表示不允许将编号为 <code>a<sub>i</sub></code>&nbsp;和&nbsp;&nbsp;<code>b<sub>i</sub></code>的人归入同一组。当可以用这种方法将所有人分进两组时，返回 <code>true</code>；否则返回 <code>false</code>。</p>
//
//<p>&nbsp;</p>
//
//<ol> 
//</ol>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 4, dislikes = [[1,2],[1,3],[2,4]]
//<strong>输出：</strong>true
//<strong>解释：</strong>group1 [1,4], group2 [2,3]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 3, dislikes = [[1,2],[1,3],[2,3]]
//<strong>输出：</strong>false
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 2000</code></li> 
// <li><code>0 &lt;= dislikes.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>dislikes[i].length == 2</code></li> 
// <li><code>1 &lt;= dislikes[i][j] &lt;= n</code></li> 
// <li><code>a<sub>i</sub>&nbsp;&lt; b<sub>i</sub></code></li> 
// <li><code>dislikes</code>&nbsp;中每一组都 <strong>不同</strong></li> 
//</ul>
//
//<p>&nbsp;</p>
//
//<div><div>Related Topics</div><div><li>深度优先搜索</li><li>广度优先搜索</li><li>并查集</li><li>图</li></div></div><br><div><li>👍 319</li><li>👎 0</li></div>

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PossibleBipartition886 {
    public static void main(String[] args) {
        Solution solution = new PossibleBipartition886().new Solution();
        // true
        System.out.println(solution.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        // false
        System.out.println(solution.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        // true
        System.out.println(solution.possibleBipartition(5, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双色法
        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 构建图
            // value 表示可以分到一堆的
            Map<Integer, Set<Integer>> map = this.makeMap(n, dislikes);
            // 双色填充

            boolean[] traveled = new boolean[n + 1];
            // 0 未染色 1 染色1   2 染色2
            int[] color = new int[n + 1];

            for (int i = 1; i <= n; i++) {

                if (traveled[i]) {
                    continue;
                }

                // 没有颜色 先赋值一个颜色
                if (color[i] == 0) {
                    color[i] = 1;
                }

                if (!this.doubleColorDfs(i, map, traveled, color)) {
                    return false;
                }
            }
            return true;
        }

        private boolean doubleColorDfs(int index,
                                       Map<Integer, Set<Integer>> map,
                                       boolean[] travel,
                                       int[] color) {

            travel[index] = true;

            int currentColor = color[index];
            int nextColor = this.nextColor(currentColor);

            for (int next : map.getOrDefault(index, new HashSet<>())) {

                if (color[next] == 0) {
                    color[next] = nextColor;
                }
                if (color[next] != nextColor) {
                    return false;
                }

                if (travel[next]) {
                    continue;
                }

                if (!this.doubleColorDfs(next, map, travel, color)) {
                    return false;
                }
            }

            return true;
        }

        private int nextColor(int color) {
            if (color == 0) {
                return 1;
            }
            if (color == 1) {
                return 2;
            }
            return 1;
        }

        private Map<Integer, Set<Integer>> makeMap(int n, int[][] dislikes) {
            Map<Integer, Set<Integer>> map = new HashMap<>();

            for (int[] dislike : dislikes) {
                map.computeIfAbsent(dislike[0], a -> new HashSet<>()).add(dislike[1]);
                map.computeIfAbsent(dislike[1], a -> new HashSet<>()).add(dislike[0]);
            }

            return map;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}