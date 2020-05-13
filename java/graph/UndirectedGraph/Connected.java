package UndirectedGraph;

import Base.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 连通分量
public class Connected<T> {

    // 如果连个端点属于一个连通分量
    // 他们的id应该是一样的
    public HashMap<T, Integer> ids;
    public int count = 0;
    public Graph<T> graph;
    public Set<T> memo;

    public Connected(Graph<T> graph) {
        this.ids = new HashMap<>();
        this.graph = graph;
        this.memo = new HashSet<>();

        for (T start : graph.keys()) {
            if (!this.memo.contains(start)) {
                dfs(start);
                count++;
            }
        }
    }

    public void dfs(T start) {
        this.memo.add(start);
        ids.put(start, this.count);
        UndirectedNode<T> temp = (UndirectedNode<T>) this.graph.adjacent(start);
        while (temp != null) {
            if (!memo.contains(temp.to)) dfs(temp.to);
            temp = temp.next;
        }
    }

    public boolean connected(T from, T to) {
        return ids.get(from).equals(ids.get(to));
    }
}
