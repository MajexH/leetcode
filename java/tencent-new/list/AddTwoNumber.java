package list;

public class AddTwoNumber {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // list 版本的
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode res = new ListNode(0), move = res;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;

            int temp = num1 + num2 + add;
            add = temp / 10;
            move.next = new ListNode(temp % 10);
            move = move.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (add != 0) {
            move.next = new ListNode(add);
        }
        return res.next;
    }

    public String addTwoNumber(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int add = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int number1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int number2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int temp = number1 + number2 + add;
            add = temp / 10;
            builder.append(temp % 10);
            if (i >= 0) i--;
            if (j >= 0) j--;
        }
        if (add != 0) builder.append(add);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddTwoNumber().addTwoNumber("321312", "145"));
    }
}
