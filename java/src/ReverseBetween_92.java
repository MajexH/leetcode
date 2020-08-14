public class ReverseBetween_92 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(1), rem = pre;
        pre.next = head;
        ListNode last = head, fast = head;
        // 先移动 fast 作为要反转的节点的范围的最右端
        int counter = n - m;
        while (counter > 0) {
            fast = fast.next;
            counter--;
        }
        // 同时移动 pre last fast 指针 让pre 指向last 的直接前继节点 last -> fast 是需要反转的节点
        while (counter < m - 1) {
            last = last.next;
            fast = fast.next;
            counter++;
            pre = pre.next;
        }
        // 现在将整个链表分成三段 1 是 pre 指向的节点 二是 last -> fast 需要反转的 三是 fast 后一个节点 在反转后要连接上的
        // 因此要保存三个地方的指针
        // tail 节点表示反转需要停止的节点 表示之后反转要连接到这个节点上
        ListNode tail = fast.next;
        // headTemp 反转之后的节点的尾结点
        ListNode headTemp = last;
        // 下面是反转的逻辑
        ListNode move = last;
        ListNode tempPre = null;
        while (move != tail) {
            ListNode next = move.next;
            move.next = tempPre;
            tempPre = move;
            move = next;
        }
        // 连接节点 pre 是第一部分的尾结点 接上反转后的头结点
        pre.next = tempPre;
        // 反转后的尾结点 接上之前的尾结点
        headTemp.next = tail;
        return rem.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        System.out.println(new ReverseBetween_92().reverseBetween(node, 2, 4));
    }
}
