package Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class Search {

    public static <T extends Comparable<T>> boolean check(Graph<T> graph, T first, T second) {
        LinkedList<T> temp = graph.adjacent(first);
        while (temp != null) {
            if (temp.getVal().compareTo(second) == 0) return true;
            temp = temp.getNext();
        }
        return false;
    }

    public static <T extends Comparable<T>> void dsfWithRecursion(Graph<T> graph, T start) {
        LinkedList<T> list = graph.adjacent(start);
        while (list.hasNext()) {
            dsfWithRecursion(graph, list.getVal());
            list = list.getNext();
        }
    }

    public static <T extends Comparable<T>> void dfsWithoutRecursion(Graph<T> graph, T start) {
        Deque<T> stack = new ArrayDeque<>();
        stack.push(start);
        while (stack.size() != 0) {
            T temp = stack.pop();
            LinkedList<T> list = graph.adjacent(temp);
            while (list.hasNext()) {
                stack.push(list.getVal());
                list = list.next();
            }
        }
    }

}
