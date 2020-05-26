public class MergeLinkedList {

    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode mergeListNode(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0), moveNode = res;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                moveNode.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                moveNode.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            moveNode = moveNode.next;
        }
        if (list1 != null) {
            moveNode.next = list1;
        }
        if (list2 != null) {
            moveNode.next = list2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);

        System.out.println(new MergeLinkedList().mergeListNode(list1, list2));
    }
}
