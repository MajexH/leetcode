package com.company;

public class First {

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 判断是否成环
     * @param node 一个待判断的链表
     * @return 成环返回 true
     */
    public boolean checkCircual(ListNode node) {
        if (node == null || node.next == null) return false;
        ListNode last = node, fast = node;

        while (true) {
            if (fast == null || fast.next == null) break;
            last = last.next;
            fast = fast.next.next;
            if (last == fast) break;
        }

        return fast != null && fast.next != null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        System.out.println(new First().checkCircual(node));
    }
}
