import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph<T> {

    private int capacity;
    private List<LinkedNode<T>> list;

    public Graph() {
    }

    public Graph(int capacity) {
        this.capacity = capacity;
        this.list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.list.add(new LinkedNode<>());
        }
    }

    public void addEdge(int from, int to) {
        for (LinkedNode<T> temp : adjacent(from)) {
            if (to == (int) temp.getVal()) {
                return;
            }
        }
        this.list.get(from).setNext((LinkedNode<T>) new LinkedNode<>(to));
    }

    public LinkedNode<T> adjacent(int index) {
        return this.list.get(index);
    }

    // 从start的位置开始dfs
    public void dfs(int start) {
        boolean[] visited = new boolean[this.capacity];
        dfsWithRecursion(start, visited);
    }

    private void dfsWithRecursion(int start, boolean[] visited) {
        System.out.println(start);
        LinkedNode<T> adjacent = adjacent(start);
        for (LinkedNode<T> temp : adjacent) {
            if (!visited[start]) {
                visited[start] = true;
                dfsWithRecursion((int) temp.getVal(), visited);
            }
        }
    }

    private void dfsWithOutRecursion(int start, boolean[] visited) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(start);
        while (list.size() != 0) {
            int top = list.get(list.size() - 1);
            System.out.println(top);
            visited[top] = true;
            for (LinkedNode<T> temp : adjacent(top)) {
                if (!visited[(int) temp.getVal()]) {
                    list.add((int) temp.getVal());
                }
            }
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<LinkedNode<T>> getList() {
        return list;
    }

    public void setList(List<LinkedNode<T>> list) {
        this.list = list;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(10);

    }
}
