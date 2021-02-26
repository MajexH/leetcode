package highFrequency.divide;

public class MergeKListsNew {

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

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return lists[i];
        }
        int mid = i + (j - i) / 2;
        ListNode left = mergeSort(lists, i, mid);
        ListNode right = mergeSort(lists, mid + 1, j);
        return merge(left, right);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode res = new ListNode(0);
        ListNode mv = res;

        while (l != null && r != null) {
            if (l.val < r.val) {
                mv.next = l;
                l = l.next;
            } else {
                mv.next = r;
                r = r.next;
            }
            mv = mv.next;
        }
        if (l != null) {
            mv.next = l;
        }
        if (r != null) {
            mv.next = r;
        }
        return res.next;
    }
}
