package ListAndTree;

import java.util.List;

public class SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode divide(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode last = node, fast = node.next;
        while (fast != null && fast.next != null) {
            last = last.next;
            fast = fast.next.next;
        }
        ListNode mid = last.next;
        last.next = null;
        return mid;
    }

    public ListNode merge(ListNode start, ListNode mid) {
        ListNode temp = new ListNode(0), remember = temp;
        while (start != null && mid != null) {
            if (start.val < mid.val) {
                temp.next = new ListNode(start.val);
                start = start.next;
            } else {
                temp.next = new ListNode(mid.val);
                mid = mid.next;
            }
            temp = temp.next;
        }
        if (start != null) {
            temp.next = start;
        }
        if (mid != null) {
            temp.next = mid;
        }
        return remember.next;
    }

    public ListNode MergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode mid = divide(node);
        ListNode a = MergeSort(node), b = MergeSort(mid);
        return merge(a, b);
    }

    public ListNode sortList(ListNode head) {
        return MergeSort(head);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(-1);
        a.next = new ListNode(5);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);

        System.out.println(new SortList().sortList(null));
    }
}
