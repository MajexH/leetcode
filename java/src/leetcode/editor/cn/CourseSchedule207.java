package leetcode.editor.cn;//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 10⁵ 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 1337 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule207 {
    public static void main(String[] args) {
        Solution solution = new CourseSchedule207().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private boolean dfs(Map<Integer, List<Integer>> map, int curNode, boolean[] globalChecked, boolean[] checked) {
            // 如果已经检测过这个节点 那么可以不用再检测
            if (globalChecked[curNode]) {
                return true;
            }
            globalChecked[curNode] = true;
            checked[curNode] = true;
            for (int node : map.getOrDefault(curNode, new ArrayList<>())) {
                // 如果 再次访问到 node 说明从 node 开始成环
                if (checked[node]) {
                    return false;
                }
                // 中断循环
                if (!this.dfs(map, node, globalChecked, checked)) {
                    checked[node] = false;
                    return false;
                }
            }

            checked[curNode] = false;
            return true;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 构建有向图
            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int[] side : prerequisites) {
                map.computeIfAbsent(side[1], a -> new ArrayList<>()).add(side[0]);
            }

            boolean[] globalChecks = new boolean[numCourses];
            // 看有向图是否成环
            for (int i = 0; i < numCourses; i++) {
                if (globalChecks[i]) {
                    continue;
                }
                if (!this.dfs(map, i, globalChecks, new boolean[numCourses])) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}