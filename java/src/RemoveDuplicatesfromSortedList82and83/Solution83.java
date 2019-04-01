package RemoveDuplicatesfromSortedList82and83;

public class Solution83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head, latter = head;
        while (latter != null) {
            if (latter.next == null && pre != latter && pre.val == latter.val) {
                pre.next = null;
                break;
            }
            if (pre.val != latter.val) {
                pre.next = latter;
                pre = latter;
            }
            latter = latter.next;
        }
        return head;
    }


    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);

        System.out.println(solution83.deleteDuplicates(list));
    }
}