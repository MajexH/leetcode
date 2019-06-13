package Graph;

public class LinkedList<T extends Comparable<T>> {

    private T val;
    private LinkedList<T> next;

    LinkedList() {}

    public LinkedList(T val) {
        this.val = val;
        this.next = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
