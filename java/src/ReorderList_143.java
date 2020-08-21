import java.util.Deque;
import java.util.LinkedList;

public class ReorderList_143 {
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

    public void reorderList(ListNode head) {
        if (head == null) return;
        Deque<ListNode> stack = new LinkedList<>();

        ListNode mv = head;
        while (mv != null) {
            stack.add(mv);
            mv = mv.next;
        }
        mv = new ListNode(2);
        boolean isLeft = true;
        while (stack.size() > 0) {
            if (isLeft) {
                mv.next = stack.removeFirst();
            } else {
                mv.next = stack.removeLast();
            }
            isLeft = !isLeft;
            mv = mv.next;
        }
        mv.next = null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        new ReorderList_143().reorderList(node);
    }
}
