package chapter2;

import java.util.LinkedList;

public class CQueue_09 {

    private LinkedList<Integer> first, second;

    public CQueue_09() {
        this.first = new LinkedList<>();
        this.second = new LinkedList<>();
    }

    public void appendTail(int value) {
        this.first.addLast(value);
    }

    public int deleteHead() {
        if (this.second.isEmpty()) {
            while (!this.first.isEmpty()) {
                this.second.addLast(this.first.removeLast());
            }
        }
        if (this.second.isEmpty()) return -1;
        return this.second.removeLast();
    }
}
