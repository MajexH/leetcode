package CourseSchedule207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 这其实是一个有向图 如果存在闭环 则不可能
public class Solution {

    //第二个条件代表边
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构造邻接表
        List<List<Integer>> map = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new LinkedList<>());
        }
        for (int[] temp : prerequisites) {
            map.get(temp[1]).add(temp[0]);
        }
        // 用来记录当前节点是否已经访问过 因为比如说 0-1 有边
        // 那么如果1有环 那么从0开始 到1之后 也能走到这个闭环
        // 所以不用再次访问
        // 如果走到1 已经访问过没有闭环 那么 从0到1再到接下来的位置 也是没有闭环的
        boolean[] total = new boolean[numCourses];
        // DFS 寻找有向环
        for (int i = 0; i < numCourses; i++) {
            if (recursion(new boolean[numCourses], map, i, total)) return false;
        }
        return true;
    }

    public boolean recursion(boolean[] visited, List<List<Integer>> map, int start, boolean[] total) {
        if (total[start]) return false;
        // 拿到邻接点
        List<Integer> list = map.get(start);
        total[start] = true;
        visited[start] = true;
        for (int j : list) {
            // 说明是第二次访问 存在闭环
            if (visited[j]) {
                return true;
            }
            else {
                // 第一次访问 递归
                if (recursion(visited, map, j, total)) return true;
            }
        }
        visited[start] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}, {0 , 1}}));
    }

}
