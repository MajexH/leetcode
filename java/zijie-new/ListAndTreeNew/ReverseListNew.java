package ListAndTreeNew;


import java.util.LinkedList;

public class ReverseListNew {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode root) {
        LinkedList<ListNode> stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            root = root.next;
        }
        ListNode remember = new ListNode(1), move = remember;
        while (stack.size() != 0) {
            move.next = stack.pop();
            move = move.next;
        }
        move.next = null;
        return remember.next;
    }
}
