import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopologySort_CourseScheduleII_210 {

    // 拓扑排序
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(i, new ArrayList<>());
        }
        for (int[] nums : prerequisites) {
            map.get(nums[1]).add(nums[0]);
        }

        boolean[] totalMemo = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 存在环则无法满足要求
            if (dfs(map, new boolean[numCourses], i, totalMemo, res)) return new int[0];
        }


        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(res.size() - 1 - i);
        }
        return resArray;
    }

    // 这个里面的memo 其实就保存了一条遍历的路径
    public boolean dfs(List<List<Integer>> map, boolean[] memo, int start, boolean[] totalMemo, List<Integer> res) {
        if (totalMemo[start]) return false;
        totalMemo[start] = true;
        memo[start] = true;
        for (int course : map.get(start)) {
            if (!memo[course]) {
                // 只有有环的时候 直接返回就行
                if (dfs(map, memo, course, totalMemo, res)) return true;
            }
            else {
                // 重复访问了 存在环
                return true;
            }
        }
        // 重新置位false的原因是 因为有向图 可能从另外一个方向访问到这个节点
        // 而这个时候 他不是成环的 因为是又向的
        memo[start] = false;
        res.add(start);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopologySort_CourseScheduleII_210().findOrder(2, new int[][]{{0,1}})));
    }

}
