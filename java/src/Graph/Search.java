package Graph;

public class Search {

    public static <T extends Comparable<T>> boolean check(Graph<T> graph, T first, T second) {
        LinkedList<T> temp = graph.adjacent(first);
        while (temp != null) {
            if (temp.getVal().compareTo(second) == 0) return true;
            temp = temp.getNext();
        }
        return false;
    }
}
