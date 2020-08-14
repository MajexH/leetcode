package chapter5;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    private int size;

    public MedianFinder() {
        this.left = new PriorityQueue<>((a, b) -> b - a);
        this.right = new PriorityQueue<>();
        this.size = 0;
    }

    public void addNum(int num) {
        if (size % 2 == 0) {
            left.add(num);
            if (right.size() > 0 && left.peek() > right.peek()) {
                int topLeft = left.poll(), topRight = right.poll();
                left.add(topRight);
                right.add(topLeft);
            }
        } else {
            right.add(num);
            if (left.size() > 0 && left.peek() > right.peek()) {
                int topLeft = left.poll(), topRight = right.poll();
                left.add(topRight);
                right.add(topLeft);
            }
        }
        size++;
    }

    public double findMedian() {
        if (size % 2 == 0) {
            int leftNumber = left.isEmpty() ? 0 : left.peek();
            int rightNumber = right.isEmpty() ? 0 : right.peek();
            return (leftNumber + rightNumber) / 2D;
        } else {
            return left.size() > right.size() ? left.peek() : right.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder a = new MedianFinder();
        a.addNum(2);
        System.out.println(a.findMedian());
        a.addNum(3);
        System.out.println(a.findMedian());
    }
}
