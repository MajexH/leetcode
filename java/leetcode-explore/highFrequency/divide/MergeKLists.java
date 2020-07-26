package highFrequency.divide;

public class MergeKLists {

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

    public ListNode mergeTwoList(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) return null;
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode res = new ListNode(1), move = res;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                move.next = node2;
                node2 = node2.next;
            } else {
                move.next = node1;
                node1 = node1.next;
            }
            move = move.next;
        }
        if (node1 != null) move.next = node1;
        if (node2 != null) move.next = node2;
        return res.next;
    }

    public ListNode divide(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        if (i > j) return null;
        int mid = (i + j) / 2;
        ListNode left = divide(lists, i, mid);
        ListNode right = divide(lists, mid + 1, j);
        return mergeTwoList(left, right);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return divide(lists, 0, lists.length - 1);
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        System.out.println(new MergeKLists().mergeKLists(new ListNode[]{ node1,node2,node3 }));
    }
}
