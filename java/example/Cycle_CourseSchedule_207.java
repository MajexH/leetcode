import java.util.ArrayList;
import java.util.List;

public class Cycle_CourseSchedule_207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] nums : prerequisites) {
            if (nums[1] == nums[0]) return false;
            map.get(nums[1]).add(nums[0]);
        }
        // 用来记录当前节点是否已经访问过 因为比如说 0-1 有边
        // 那么如果1有环 那么从0开始 到1之后 也能走到这个闭环
        // 所以不用再次访问
        // 如果走到1 已经访问过没有闭环 那么 从0到1再到接下来的位置 也是没有闭环的
        // 相当于之前的dfs的memo
        boolean[] totalMemo = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 存在环则无法满足要求
            if (dfs(map, new boolean[numCourses], i, totalMemo)) return false;
        }
        return true;
    }

    // 这个里面的memo 其实就保存了一条遍历的路径
    public boolean dfs(List<List<Integer>> map, boolean[] memo, int start, boolean[] totalMemo) {
        if (totalMemo[start]) return false;
        totalMemo[start] = true;
        memo[start] = true;
        for (int course : map.get(start)) {
            if (!memo[course]) {
                // 只有有环的时候 直接返回就行
                if (dfs(map, memo, course, totalMemo)) return true;
            }
            else {
                // 重复访问了 存在环
                return true;
            }
        }
        // 重新置位false的原因是 因为有向图 可能从另外一个方向访问到这个节点
        // 而这个时候 他不是成环的 因为是又向的
        memo[start] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Cycle_CourseSchedule_207().canFinish(4, new int[][]{ {1,0}, {2,0}, {3,1}, {3,2} }));
    }
}
