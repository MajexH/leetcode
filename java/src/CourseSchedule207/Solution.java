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
        // DFS 寻找有向环
        for (int i = 0; i < numCourses; i++) {
            if (recursion(new boolean[numCourses], map, i)) return false;
        }
        return true;
    }

    public boolean recursion(boolean[] visited, List<List<Integer>> map, int start) {
        // 拿到邻接点
        List<Integer> list = map.get(start);
        visited[start] = true;
        for (int j : list) {
            // 说明是第二次访问 存在闭环
            if (visited[j]) {
                return true;
            }
            else {
                // 第一次访问 递归
                if (recursion(visited, map, j)) return true;
            }
        }
        visited[start] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}, {0 , 1}}));
    }

}
