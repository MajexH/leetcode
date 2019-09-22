import java.util.Iterator;

public class LinkedNode<T> implements Iterable<LinkedNode<T>>, Iterator<LinkedNode<T>> {

    private T val;
    private LinkedNode<T> next;

    @Override
    public Iterator<LinkedNode<T>> iterator() {
        return this;
    }

    public LinkedNode() {
    }

    public LinkedNode(T val) {
        this.val = val;
        this.next = null;
    }

    public T getVal() {
        return val;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public LinkedNode<T> next() {
        return this.next;
    }
}
