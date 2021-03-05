package tencent.list;

public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int i, int j) {
        if (i > j) return null;
        if (i == j) return lists[i];
        int mid = i + ((j - i) >> 1);
        return merge(mergeSort(lists, i, mid), mergeSort(lists, mid + 1, j));
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode rem = new ListNode(1), mv = rem;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                mv.next = l2;
                l2 = l2.next;
            } else {
                mv.next = l1;
                l1 = l1.next;
            }
            mv = mv.next;
        }
        if (l1 != null) mv.next = l1;
        if (l2 != null) mv.next = l2;
        return rem.next;
    }
}
