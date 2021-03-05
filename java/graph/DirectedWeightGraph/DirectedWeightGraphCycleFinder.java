package DirectedWeightGraph;

import java.util.LinkedList;
import java.util.List;

public class DirectedWeightGraphCycleFinder {

    private boolean[] marked;  // 全局的 memo 表示是否已经访问
    private Edge[] edgeTo;     // 保存 path 的上一条边 这样可以在 cycleStack 中保存
    private boolean[] onStack; // 在一次 dfs 中保存

    public List<Edge> getCycleStack() {
        return cycleStack;
    }

    private List<Edge> cycleStack; // cycle 中有哪些边

    public DirectedWeightGraphCycleFinder(DirectedWeightGraph g) {
        this.marked = new boolean[g.getCapacity()];
        this.edgeTo = new Edge[g.getCapacity()];
        this.onStack = new boolean[g.getCapacity()];

        for (int v = 0; v < g.getCapacity(); v++)
            if (!marked[v]) dfs(g, v);
    }

    private void dfs(DirectedWeightGraph g, int start) {
        this.marked[start] = true;
        this.onStack[start] = true;
        for (Edge adj : g.adj(start)) {
            int to = adj.to;
            if (!this.marked[to]) {
                dfs(g, to);
                edgeTo[to] = adj;
            } else if (onStack[to]) {
                this.cycleStack = new LinkedList<>();
                // 找到重复点
                Edge f = adj;
                while (f.from != to) {
                    cycleStack.add(f);
                    f = edgeTo[f.from];
                }
                cycleStack.add(f);
                return;
            }
        }
        this.onStack[start] = false;
    }

    public boolean hasCycle() {
        return cycleStack != null;
    }
}
