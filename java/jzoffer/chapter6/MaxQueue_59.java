package chapter6;

import java.util.ArrayList;
import java.util.List;

public class MaxQueue_59 {

    private static class MaxStack {
        List<Integer> list;
        List<Integer> max;

        public MaxStack() {
            this.list = new ArrayList<>();
            this.max = new ArrayList<>();
        }

        public void add(Integer num) {
            this.list.add(num);
            if (this.max.isEmpty() || this.max.get(this.max.size() - 1) < num) {
                this.max.add(num);
            } else {
                this.max.add(this.max.get(this.max.size() - 1));
            }
        }

        public int remove() {
            if (this.list.isEmpty()) return -1;
            this.max.remove(this.max.size() - 1);
            return this.list.remove(this.list.size() - 1);
        }

        public int max() {
            if (!this.max.isEmpty())
                return this.max.get(this.max.size() - 1);
            else
                return -1;
        }

        public int size() {
            return this.list.size();
        }
    }

    private MaxStack s1;
    private MaxStack s2;

    public MaxQueue_59() {
        this.s1 = new MaxStack();
        this.s2 = new MaxStack();
    }

    public int max() {
        return Math.max(s1.max(), s2.max());
    }

    public void addLast(int num) {
        this.s1.add(num);
    }

    public int removeFirst() {
        if (s2.size() == 0) {
            while (this.s1.size() > 0) {
                this.s2.add(this.s1.remove());
            }
        }
        if (this.s2.size() == 0) return -1;
        else return this.s2.remove();
    }

    public int size() {
        return this.s1.size() + this.s2.size();
    }
}
