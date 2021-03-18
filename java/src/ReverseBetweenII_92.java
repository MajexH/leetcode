public class ReverseBetweenII_92 {

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

    // 反转两个节点的之间的数据
    // left right 表示的位置
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode pre = new ListNode(1);
        pre.next = head;
        ListNode mv = head, remember = pre;
        // 定位开始反转的节点
        int counter = 1;
        while (mv != null && counter < left) {
            mv = mv.next;
            pre = pre.next;
            counter++;
        }

        // 这时候找到了 原来的pre 头 以 逆转之后的 newEnd
        ListNode newEnd = mv, lastPre = pre;

        // 定位结束反转的节点
        while (mv != null && counter <= right) {
            pre = pre.next;
            mv = mv.next;
            counter++;
        }

        reverse(newEnd, mv);

        lastPre.next = pre;
        newEnd.next = mv;

        return remember.next;
    }

    // endNext 是结束节点的后一个
    // 其实这一步 可以融合早 counter <= right 的遍历中
    private void reverse(ListNode head, ListNode endNext) {
        ListNode pre = null;

        while (head != endNext) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

}
