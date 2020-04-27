package UndirectedGraph;

import Base.Node;

public class UndirectedNode<T> implements Node<T> {

    public T to;
    public UndirectedNode<T> next;

    public UndirectedNode(T to) {
        this.to = to;
        this.next = null;
    }

    /**
     *
     * @param to
     * @return boolean 表示是否加入成功
     */
    public boolean addNode(T to) {
        // 加入第一个节点的时候的判断
        if (this.to == to) return true;
        UndirectedNode<T> temp = this.next;
        // 加入第二个节点时的判断
        if (temp == null) {
            this.next = new UndirectedNode<>(to);
            return true;
        }
        while (temp.next != null) {
            if (temp.to == this.to) return false;
            temp = temp.next;
        }
        temp.next = new UndirectedNode<>(to);
        return true;
    }

    @Override
    public String toString() {
        return "Node{" +
                "to=" + to +
                ", next=" + next +
                '}';
    }
}
