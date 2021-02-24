package DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraph {

    public int getCapacity() {
        return capacity;
    }

    private int capacity;
    private List<LinkedList<Integer>> nodes;

    public DirectedGraph(int capacity) {
        this.capacity = capacity;
        this.nodes = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            nodes.add(new LinkedList<>());
        }
    }

    public LinkedList<Integer> adj(int node) {
        return this.nodes.get(node);
    }

    public void addEdge(int from, int to) {
        this.nodes.get(from).add(to);
    }

    public DirectedGraph reverse() {
        DirectedGraph reversed = new DirectedGraph(this.capacity);
        for (int from = 0; from < this.capacity; from++) {
            for (Integer to : adj(from)) {
                if (to != null) {
                    reversed.addEdge(to, from);
                }
            }
        }
        return reversed;
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(9);
        g.addEdge(1, 0);
        g.addEdge(0, 1);
        g.addEdge(3, 4);
        g.addEdge(2, 6);
        g.addEdge(8, 3);
        g.addEdge(5, 1);
        g.addEdge(1, 7);
        DirectedGraph re = g.reverse();
        System.out.println();
    }
}
