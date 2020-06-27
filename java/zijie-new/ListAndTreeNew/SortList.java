package ListAndTreeNew;

public class SortList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode divide(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        // 这儿必须要不同 不然会在这儿死循环
        ListNode fast = node.next, last = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            last = last.next;
        }
        ListNode mid = last.next;
        last.next = null;
        return mid;
    }

    public ListNode MergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode mid = divide(node);
        ListNode left = MergeSort(node), right = MergeSort(mid);
        return merge(left, right);
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

    public ListNode sortList(ListNode head) {
        return MergeSort(head);
    }
}
