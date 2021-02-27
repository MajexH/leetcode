package DirectedWeightGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 加权有向图
public class DirectedWeightGraph {

    public int getCapacity() {
        return capacity;
    }

    int capacity;
    List<List<Edge>> nodes;

    public DirectedWeightGraph(int capacity) {
        this.capacity = capacity;
        this.nodes = new ArrayList<>(this.capacity);
        for (int i = 0; i < capacity; i++) {
            this.nodes.add(new LinkedList<>());
        }
    }

    // 有向图只用加入一遍
    public void addEdge(int from, int to, int weight) {
        this.nodes.get(from).add(new Edge(from, to, weight));
    }

    public List<Edge> adj(int node) {
        return this.nodes.get(node);
    }

    // 返回所有的边
    public List<Edge> edges() {
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            res.addAll(this.nodes.get(i));
        }
        return res;
    }
}
