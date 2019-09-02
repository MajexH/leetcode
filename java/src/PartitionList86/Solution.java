package PartitionList86;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(0), b = a, c = new ListNode(0), d = c;
        a.next = head;
        while (head != null) {
            if (head.val < x) {
                b.next = head;
                b = b.next;
            } else {
                d.next = head;
                d = d.next;
            }
            head = head.next;
        }
        d.next = null;
        b.next = c.next;
        return a.next;
    }
}
