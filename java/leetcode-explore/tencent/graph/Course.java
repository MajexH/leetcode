package tencent.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {

    // 判断有向图是否成环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        boolean[] marked = new boolean[numCourses];
        boolean[] memo = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!memo[i]) {
                if (isCycle(map, i, memo, marked)) return false;
            }
        }
        return true;
    }

    public boolean isCycle(Map<Integer, List<Integer>> map, int start, boolean[] memo, boolean[] marked) {
        if (memo[start]) return false;
        memo[start] = true;
        marked[start] = true;
        for (int adj : map.getOrDefault(start, new ArrayList<>())) {
            if (!marked[adj]) {
                // 成环直接跳出
                if (isCycle(map, adj, memo, marked)) {
                    marked[start] = false;
                    return true;
                }
            } else {
                return true;
            }
        }
        marked[start] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Course().canFinish(2, new int[][]{{1,0},{0,1}}));
    }
}
