package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinStack {

    private ArrayList<Integer> stack;
    private ArrayList<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        this.min = new ArrayList<>();
    }

    public void push(int x) {
        this.stack.add(x);
        if (this.min.size() == 0) {
            this.min.add(x);
        } else {
            if (this.min.get(this.min.size() - 1) > x) {
                this.min.add(x);
            } else {
                this.min.add(this.min.get(this.min.size() - 1));
            }
        }
    }

    public void pop() {
        if (this.stack.size() > 0) {
            this.stack.remove(this.stack.size() - 1);
            this.min.remove(this.min.size() - 1);
        }
    }

    public int top() {
        return this.stack.get(this.stack.size() - 1);
    }

    public int getMin() {
        return this.min.get(this.min.size() - 1);
    }
}
