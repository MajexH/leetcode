package dataStructure;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void push(int x) {
        this.stack1.push(x);
        if (this.stack2.size() == 0) this.stack2.push(x);
        else {
            if (this.stack2.peek() > x) this.stack2.push(x);
            else this.stack2.push(this.stack2.peek());
        }
    }

    public void pop() {
        if (this.stack1.size() > 0) {
            this.stack1.pop();
            this.stack2.pop();
        }
    }

    public int top() {
        if (this.stack1.size() > 0)
            return this.stack1.peek();
        else return -1;
    }

    public int getMin() {
        if (this.stack2.size() > 0)
            return this.stack2.peek();
        else return -1;
    }
}
