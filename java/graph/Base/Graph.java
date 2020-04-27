package Base;

import java.util.Set;

public interface Graph<T> {

    public Set<T> keys();

    void addEdge(T from, T to);

    Node<T> adjacent(T from);
}
