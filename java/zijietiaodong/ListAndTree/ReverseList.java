package ListAndTree;


import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode recursion(ListNode node) {
        if (node.next == null) return node;
        ListNode after = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return after;
    }

    public ListNode reverseList(ListNode root) {
       if (root == null) return null;
       return recursion(root);
    }

    public ListNode reverseList1(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        if (stack.size() == 0) {
            return null;
        } else {
            head = stack.removeLast();
        }
        ListNode remember = head;
        while (stack.size() != 0) {
            head.next = stack.removeLast();
            head = head.next;
            head.next = null;
        }
        return remember;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(new ReverseList().reverseList(node));
    }
}
