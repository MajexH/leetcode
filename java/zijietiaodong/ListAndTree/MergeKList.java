package ListAndTree;

public class MergeKList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0), remember = res;
        while (true) {
            boolean flag = true;
            int min = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null) {
                    flag = false;
                    if (min == -1 || lists[min].val > node.val) {
                        min = i;
                    }
                }
            }
            if (min != -1) {
                res.next = new ListNode(lists[min].val);
                res = res.next;
                lists[min] = lists[min].next;
            }
            if (flag) break;
        }

        return remember.next;
    }
}
