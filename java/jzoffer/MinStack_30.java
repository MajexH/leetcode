import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinStack_30 {

    LinkedList<Integer> min = new LinkedList<>();
    LinkedList<Integer> nums = new LinkedList<>();
    /** initialize your data structure here. */
    public MinStack_30() {}

    public void push(int x) {
        nums.add(x);
        if (min.isEmpty()) {
            min.add(x);
            return;
        }
        min.add(Math.min(x, min.get(min.size() - 1)));
    }

    public void pop() {
        min.removeLast();
        nums.removeLast();
    }

    public int top() {
        return nums.getLast();
    }

    public int min() {
        return min.getLast();
    }
}
