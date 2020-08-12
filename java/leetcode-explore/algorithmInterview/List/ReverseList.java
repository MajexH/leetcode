package algorithmInterview.List;

public class ReverseList {

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
    // 换一种方法 实现 o(1) 的迭代转换
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode reverseHead = null;
        ListNode next = head.next;
        while (true) {
            head.next = reverseHead;
            reverseHead = head;
            head = next;
            if (next == null) break;
            next = next.next;
        }
        return reverseHead;
    }
    // 迭代的 o(1)
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, last = head.next, lastNext = last.next;
        // 两个节点的情况
        if (last.next == null) {
            last.next = pre;
            pre.next = null;
            return last;
        }
        // 为了后面好走 需要设置为 null
        head.next = null;
        while (last != null) {
            last.next = pre;
            pre = last;
            last = lastNext;
            // 这个地方可能为 null 说明已经到最后了 且最后走完了
            if (lastNext == null) break;
            lastNext = lastNext.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseList().reverseList(head));
    }
}
