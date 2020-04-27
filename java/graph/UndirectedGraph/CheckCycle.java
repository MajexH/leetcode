package UndirectedGraph;

import Base.Graph;
import Base.Node;

import java.util.HashSet;
import java.util.Set;

public class CheckCycle<T> {

    // memo 记录在dfs的过程中的节点
    public Set<T> memo;

    public Graph<T> graph;

    public boolean hasCycle = false;

    public CheckCycle(Graph<T> graph) {
        this.graph = graph;
        this.memo = new HashSet<>();
        for (T start : graph.keys()) {
            if (!this.memo.contains(start)) {
                dfs(start, start);
            }
        }
    }

    public void dfs(T start, T parent) {
        memo.add(start);
        UndirectedNode<T> temp = (UndirectedNode<T>) graph.adjacent(start);
        while (temp != null) {
            if (!memo.contains(temp.to))
                dfs(temp.to, start);
            // 因为是无向图 因此在访问的时候 会在子节点上 重新访问父节点过来的那条边 因此这样记录父节点即可
            else if(temp.to != parent)
                hasCycle = true;
            temp = temp.next;
        }
    }
}
