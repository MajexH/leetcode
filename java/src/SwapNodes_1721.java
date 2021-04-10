import java.util.ArrayList;
import java.util.List;

public class SwapNodes_1721 {

    public static class ListNode {
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

    public ListNode swapNodes(ListNode head, int k) {
        int i = k - 1;
        int j = getLen(head) - k;

        if (i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }

        ListNode mv = new ListNode(1);
        mv.next = head;
        ListNode rem = mv;

        ListNode first = null, second = null;

        while (mv != null) {
            if (i == 0) first = mv;
            if (j == 0) second = mv;
            mv = mv.next;
            i--;
            j--;
        }

        assert first != null;
        assert second != null;

        if (first.next == second) {
            first.next = second.next;
            second.next = first.next.next;
            first.next.next = second;
        } else {
            ListNode preNext = first.next.next, lastNext = second.next.next;
            ListNode next = first.next;
            first.next = second.next;
            second.next = next;
            first.next.next = preNext;
            second.next.next = lastNext;
        }

        return rem.next;
    }

    public int getLen(ListNode node) {
        int res = 0;
        while (node != null) {
            res++;
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(7);
        node.next = new ListNode(9);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next.next.next = new ListNode(0);
        node.next.next.next.next.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next.next.next.next.next = new ListNode(5);

        System.out.println(new SwapNodes_1721().swapNodes(node, 5));
    }
}
