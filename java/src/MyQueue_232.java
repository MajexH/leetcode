import java.util.LinkedList;
import java.util.List;

public class MyQueue_232 {
    // 栈实现队列
    private LinkedList<Integer> s1, s2;
    /** Initialize your data structure here. */
    public MyQueue_232() {
        this.s1 = new LinkedList<>();
        this.s2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.s1.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        mvData();
        return this.s2.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        mvData();
        return this.s2.getLast();
    }

    private void mvData() {
        if (this.s2.isEmpty()) {
            while (!this.s1.isEmpty()) {
                this.s2.addLast(this.s1.removeLast());
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.s1.isEmpty() && this.s2.isEmpty();
    }
}
