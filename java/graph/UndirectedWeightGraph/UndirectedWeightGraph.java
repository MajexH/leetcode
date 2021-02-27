package UndirectedWeightGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightGraph {

    public int getCapacity() {
        return capacity;
    }

    private int capacity;
    // 邻接表
    private List<LinkedList<Edge>> nodes;

    public UndirectedWeightGraph(int capacity) {
        this.capacity = capacity;
        this.nodes = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.nodes.add(new LinkedList<>());
        }
    }

    public LinkedList<Edge> adj(int node) {
        return this.nodes.get(node);
    }

    public void addEdge(int from, int to, int weight) {
        Edge edge = new Edge(from, to, weight);
        this.nodes.get(from).add(edge);
        this.nodes.get(to).add(edge);
    }

    public List<Edge> getEdges() {
        List<Edge> res = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            for (Edge e : adj(i)) {
                // 因为是从小往大的走 所以 这样判断即可
                if (e.other(i) > i) {
                    res.add(e);
                }
            }
        }
        return res;
    }
}
