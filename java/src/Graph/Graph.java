package Graph;

import java.util.HashMap;
import java.util.Map;

public class Graph<T extends Comparable<T>> {

    private int totalPoint;
    private Map<T, LinkedList<T>> array;

    public Graph(int totalPoint) {
        this.totalPoint = totalPoint;
        this.array = new HashMap<>();
    }

    public void addEdge(T first, T second) {
        LinkedList<T> temp;
        if (this.array.containsKey(first)) {
            LinkedList<T> pre = new LinkedList<T>();
            temp = this.array.get(first);
            pre.setNext(temp);
            while (temp != null) {
                if (temp.getVal().compareTo(second) == 0) {
                    return;
                }
                temp = temp.getNext();
                pre = pre.getNext();
            }
            pre.setNext(new LinkedList<>(second));
        } else {
            temp = new LinkedList<>(second);
            this.array.put(first, temp);
        }
        if (this.array.containsKey(second)) {
            temp = this.array.get(second);
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new LinkedList<>(first));
        } else {
            temp = new LinkedList<>(first);
            this.array.put(second, temp);
        }
    }

    public LinkedList<T> adjacent(T key) {
        if (this.array.containsKey(key))
            return this.array.get(key);
        return null;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "totalPoint=" + totalPoint +
                ", array=" + array +
                '}';
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<Integer>(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 5);
        graph.addEdge(0, 6);
        graph.addEdge(1, 0);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        System.out.println(Search.check(graph, 0, 1));
    }
}
