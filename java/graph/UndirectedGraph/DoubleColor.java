package UndirectedGraph;

import Base.Node;

// 实际上就是二分图
public class DoubleColor {
    // 使用 DFS 在遍历的时候不停的涂色
    // 如果访问过 而且 涂色是相同的 则不是二分图

    public static boolean canDoubleColor(UndirectedGraph<Integer> g) {
        boolean[] marked = new boolean[g.getSize()];
        boolean[] color = new boolean[g.getSize()];
        // 假设所有的点都被映射到 0 -> g.getSize() - 1 上
        for (int i = 0; i < g.getSize(); i++) {
            if (!dfs(g, marked, color, i)) return false;
        }
        return true;
    }

    // 用 color 来表示断点的色彩
    private static boolean dfs(UndirectedGraph<Integer> g, boolean[] marked, boolean[] color, int start) {
        marked[start] = true;
        UndirectedNode<Integer> temp = (UndirectedNode<Integer>) g.adjacent(start);
        while (temp != null) {
            if (!marked[temp.to]) {
                // 还未遍历过的边 染上不同的颜色
                color[temp.to] = !color[start];
                if (!dfs(g, marked, color, temp.to)) {
                    return false;
                }
            } else {
                // 如果已经是遍历过的点 而且颜色相同 说明是没办法 二分图的
                if (color[start] == color[temp.to]) return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
