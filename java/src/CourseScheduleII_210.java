import java.util.*;

public class CourseScheduleII_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        Set<Integer> inDegreeEqualsZero = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) inDegreeEqualsZero.add(i);
        }

        while (inDegreeEqualsZero.size() > 0) {
            Iterator<Integer> iterator = inDegreeEqualsZero.iterator();
            // 入度为 0 的点
            int node = iterator.next();
            // 删除入度为 0 的点
            inDegreeEqualsZero.remove(node);
            res.add(node);
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == node) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0)
                        inDegreeEqualsZero.add(prerequisite[0]);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            // 表示不存在 拓扑排序
            if (inDegree[i] != 0) return new int[0];
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public boolean dfs(int start, boolean[] totalMemo, boolean[] memo, List<List<Integer>> map, Deque<Integer> res) {
        // 已经在总体上访问过 就不用再次访问了
        if (totalMemo[start]) return true;
        totalMemo[start] = true;
        memo[start] = true;
        for (int next : map.get(start)) {
            // 下一个节点还没有访问过
            if (!memo[next]) {
                // 如果已经在下面的循环中成环 则不用再去访问其他节点
                if (!dfs(next, totalMemo, memo, map, res)) {
                    return false;
                }
            } else {
                // 已经成环
                return false;
            }
        }
        memo[start] = false;
        res.add(start);
        return true;
    }

    public int[] findOrderRecursion(int numCourses, int[][] prerequisites) {
        // 邻接表
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        // 保存结果
        Deque<Integer> res = new LinkedList<>();
        // totalMemo
        boolean[] totalMemo = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            // 如果成环
            if (!dfs(i, totalMemo, new boolean[numCourses], map, res)) {
                return new int[0];
            }
        }
        int[] resArray = new int[res.size()];
        int counter = 0;
        while (res.size() > 0) {
            resArray[counter++] = res.removeLast();
        }
        return resArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CourseScheduleII_210().findOrder(4, new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        })));
    }
}
