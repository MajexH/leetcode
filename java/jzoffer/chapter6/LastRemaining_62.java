package chapter6;

import java.util.ArrayList;

public class LastRemaining_62 {

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        public void remove() {
            this.val = this.next.val;
            this.next = this.next.next;
        }
    }

    public class CycleList {
        ListNode head;
        ListNode tail;

        public void add(int n) {
            if (head == null) {
                head = new ListNode(n);
                tail = head;
            } else {
                tail.next = new ListNode(n);
                tail = tail.next;
            }
            tail.next = head;
        }

    }

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 表示上一次移除数据的位置
        int idx = 0;
        while (n > 1) {
            // 计算这次需要移除数据的位置
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    // 直接用循环链表里面去模拟的删除 直接炸了
    // 超时 因为时间复杂度是 首先遍历 n 这个长度
    // 然后再 n 这长度里面还要遍历 m 的长度
    public int lastRemaining1(int n, int m) {
        CycleList c = new CycleList();

        for (int i = 0; i < n; i++) {
            c.add(i);
        }

        ListNode head = c.head;

        int counter = 1;
        while (head.next != head) {

            while (counter == m && head.next != head) {
                head.remove();
                counter = 1;
            }
            head = head.next;
            counter++;
        }
        return head.val;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining_62().lastRemaining(5,3));
    }
}
