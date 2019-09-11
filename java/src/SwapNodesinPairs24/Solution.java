package SwapNodesinPairs24;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode swapPairs(ListNode head) {
        // 用一个pre来简化操作
        ListNode record = new ListNode(0), pre = record;
        record.next = head;
        while (head!= null && head.next != null) {
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            pre.next = temp;
            head = head.next;
            pre = pre.next.next;
        }
        return record.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
        System.out.println(new Solution().swapPairs(head));
    }
}
