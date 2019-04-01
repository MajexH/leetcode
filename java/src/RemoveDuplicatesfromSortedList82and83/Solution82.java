package RemoveDuplicatesfromSortedList82and83;

public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode add = new ListNode(0), pre = add, latter = head;
        add.next = head;
        while (latter != null) {
            ListNode last = latter.next;
            while (last != null && last.val == latter.val) {
                last = last.next;
            }
            if (latter.next != last) {
                pre.next = last;
            } else {
                pre = latter;
            }
            latter = last;
        }
        return add.next;
    }

    public static void main(String[] args) {
        Solution82 solution = new Solution82();
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(3);
        list.next.next.next.next.next = new ListNode(3);
//        list.next.next.next.next.next.next = new ListNode(5);
        System.out.println(solution.deleteDuplicates(list));
    }
}
