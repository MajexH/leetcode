import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes_802 {

    // 其实就是判断成环
    // 三色标记
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] colors = new int[graph.length];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, colors, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int[] color, int start) {
        if (color[start] > 0) {
            // 有颜色看是否安全
            return color[start] == 2;
        }
        // 遍历过 1 次
        color[start] = 1;
        for (int adj : graph[start]) {
            if (!dfs(graph, color, adj)) {
                // 不安全的
                return false;
            }
        }
        // 走到这儿 说明一定安全
        color[start] = 2;
        return true;
    }
}
