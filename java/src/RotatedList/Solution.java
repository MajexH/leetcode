package RotatedList;

public class Solution {

    public static int length(ListNode listNode) {
        int counter = 0;
        while (listNode != null) {
            listNode = listNode.next;
            counter++;
        }
        return counter;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0), last = head;
        pre.next = head;
        int length = length(head), move = k % length, counter = 0;

        if (move == 0) {
            return head;
        }
        while (last != null) {
            if (counter <= length - move - 1) {
                pre = pre.next;
            }
            counter++;
            last = last.next;
        }


        ListNode recordHead = pre.next, recordPre = pre;
        while (pre.next != null) {
            pre = pre.next;
        }

        pre.next = head;
        recordPre.next = null;

        return recordHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(rotateRight(listNode, 5));
    }
}
