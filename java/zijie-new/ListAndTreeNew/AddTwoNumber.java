package ListAndTreeNew;

public class AddTwoNumber {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 大数相加
     * @param num1
     * @param num2
     * @return
     */
    public String addTwoNumber(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0) {
            int tempNum1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int tempNum2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int temp = add + tempNum1 + tempNum2;
            builder.append(temp % 10);
            add = temp / 10;
        }
        if (add != 0) builder.append(add);
        return builder.reverse().toString();
    }

    /**
     * 链表版
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), remember = res;
        int add = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int temp = add + num1 + num2;
            res.next = new ListNode(temp % 10);
            res = res.next;
            add = temp / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (add != 0) res.next = new ListNode(add);
        return remember.next;
    }

    public static void main(String[] args) {
        System.out.println(new AddTwoNumber().addTwoNumber("12465", "1342"));
    }
}
