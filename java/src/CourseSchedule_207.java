import java.util.*;

public class CourseSchedule_207 {

    /**
     * 实际上就是 DFS 直接访问遍历整张图，用 totalMemo 来记录之前已经访问过的节点
     * 因为外层是一个 for 循环来遍历所有节点的 这样可以节约时间
     * @param memo 从当前 start 节点开始访问的记录表
     * @param map 图的邻接表 表示方法
     * @param start 图的遍历的开始节点
     * @param totalMemo 整体的 memo，因为图可能是分断的，可能这个连通分量 跟 另外一个不想连接
     * @return 成环 返回 false 不成环 返回 true
     */
    public boolean dfs(boolean[] memo, List<List<Integer>> map, int start, boolean[] totalMemo) {
        if (totalMemo[start]) return true;
        totalMemo[start] = true;
        memo[start] = true;
        for (int next : map.get(start)) {
            if (!memo[next]) {
                // 成环
                if (!dfs(memo, map, next, memo)) {
                    return false;
                }
            } else {
                // 再次访问就会失败 表示成环
                return false;
            }
        }
        // 这个地方必须置位 false 防止从另外一个方向访问到的时候 误以为成环
        memo[start] = false;
        return true;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            // 自成环
            if (prerequisite[1] == prerequisite[0]) return false;
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 指示哪些已经访问过
        boolean[] totalMemo = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            // 成环
            if (!dfs(new boolean[numCourses], map, i, totalMemo)) {
                return false;
            }
        }
        return true;
    }

    // 拓扑排序
    // 一种实现拓扑排序的方式就是去寻找入度为 0 的点 然后不停的删除
    // 再去寻找 入度为 0 的点 进行删除 最后出来的 stack 就是拓扑排序
    // 如果这个时候里面还有 出入度 都部位 0 的点 那就意味着 这个是有环的
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 保存所有节点的入度
        // 因为节点编号是从 0 -> numCourses 所以一维数组就够了
        int[] inDegree = new int[numCourses];

        // 保存所有入度为 0 的点
        Set<Integer> inDegreeEqualsZero = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        // 构建入度为 0 的 set
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) inDegreeEqualsZero.add(i);
        }

        // 没有入度为 0 的点 说明根本不可能形成拓扑排序 也就没办法完成课程
        if (inDegreeEqualsZero.size() == 0) return false;

        while (inDegreeEqualsZero.size() != 0) {
            Iterator<Integer> iterator = inDegreeEqualsZero.iterator();
            int node = iterator.next();
            // 去除入度为 0 的点
            inDegreeEqualsZero.remove(node);
            // 去除 node 这个点 只有 所有跟 node 相关的点 都需要减少一个 入度
            for (int[] prerequisite : prerequisites) {
                // 如果这个点的来源是现在这个 入度 为0 的点 那么就减少一个入度
                if (prerequisite[1] == node) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        inDegreeEqualsZero.add(prerequisite[0]);
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            // 这个地方说明还有点相连，因此是无法完成的
            if (inDegree[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule_207().canFinish(4, new int[][]{
                {1,0},
                {2,0},
                {0,2},
                {0,3}
        }));
    }
}
