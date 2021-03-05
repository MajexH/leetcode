package meituan;

public class ReverseKGroup {

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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    private static class Pair {
        ListNode head, tail;

        public Pair(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    // k 个一组翻转
    public ListNode reverseKGroup(ListNode head, int k) {

        // mv 代表的 要翻转的 tail 节点
        ListNode mv = new ListNode(1);
        mv.next = head;
        ListNode pre = mv;
        ListNode rem = pre;
        int count = 0;
        while (mv != null) {
            if (count < k) {
                count++;
                mv = mv.next;
                continue;
            }

            // count == k
            // mv 指向了 pre 的节点
            // 定位 转换的 tail 节点
            ListNode next = mv.next;
            Pair p = reverseGroupBetween(pre.next, mv);
            pre.next = p.head;
            p.tail.next = next;
            // 重新定位
            pre = p.tail;
            mv = pre;
            count = 0;
        }
        return rem.next;
    }

    private Pair reverseGroupBetween(ListNode head, ListNode tail) {
        ListNode newHead = null;
        ListNode newTail = head;
        ListNode end = tail.next;
        while (head != end) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return new Pair(newHead, newTail);
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        h.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseKGroup().reverseKGroup(h, 2));
    }
}
