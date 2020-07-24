package chapter2.tree;

import java.util.LinkedList;

public class ImplementQueueUseTwoStacks {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public ImplementQueueUseTwoStacks() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        this.stack1.add(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (this.stack2.size() <= 0) {
            removeAllElementToStack2();
        }
        return this.stack2.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        if (this.stack2.size() <= 0) {
            removeAllElementToStack2();
        }
        if (this.stack2.size() == 0) return -1;
        return this.stack2.getLast();
    }

    private void removeAllElementToStack2() {
        while (this.stack1.size() > 0) {
            this.stack2.add(this.stack1.removeLast());
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack2.size() == 0 && this.stack1.size() == 0;
    }
}
