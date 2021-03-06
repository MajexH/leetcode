package tencent.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!memo[i]) {
                if (isCycle(map, stack, i, memo, marked)) return new int[]{};
            }
        }

        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[stack.size() - i - 1] = stack.get(i);
        }
        return res;
    }

    // 边找 边根据逆后续排列寻找 topology 的 sort顺序
    public boolean isCycle(Map<Integer, List<Integer>> map, List<Integer> stack, int start, boolean[] memo, boolean[] marked) {
        if (memo[start]) return false;
        memo[start] = true;
        marked[start] = true;
        for (int adj : map.getOrDefault(start, new ArrayList<>())) {
            if (!marked[adj]) {
                // 成环直接跳出
                if (isCycle(map, stack, adj, memo, marked)) {
                    marked[start] = false;
                    return true;
                }
            } else {
                return true;
            }
        }
        marked[start] = false;
        stack.add(start);
        return false;
    }
}
