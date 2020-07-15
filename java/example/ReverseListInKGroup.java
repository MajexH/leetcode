import java.util.ArrayList;
import java.util.List;

public class ReverseListInKGroup {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode add = new ListNode(1), remember = add;
        int counter = 0;
        List<ListNode> list = new ArrayList<>();

        while (head != null) {
            while (counter < k && head != null) {
                list.add(head);
                counter++;
                head = head.next;
            }
            if (counter == k) {
                for (int i = list.size() - 1; i >= 0; i--) {
                    add.next = list.get(i);
                    add = add.next;
                }
                list.clear();
                counter = 0;
            } else {
                for (int i = 0; i < list.size(); i++) {
                    add.next = list.get(i);
                    add = add.next;
                }
                list.clear();
                counter = 0;
            }
        }
        add.next = null;
        return remember.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        //System.out.println(new ReverseListInKGroup().reverseKGroup(node, 2));
        System.out.println(new ReverseListInKGroup().reverseKGroup(node, 3));
    }
}
