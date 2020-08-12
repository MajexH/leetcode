package algorithmInterview.List;

public class PalindromeList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 要求的是 o(n) 的时间 o(1) 的空间
    // 因此 只需要将后面一半的 list 反转 跟前面一半的 list 比较即可
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode last = head, fast = head.next;
        while (fast != null && fast.next != null) {
            last = last.next;
            fast = fast.next.next;
        }
        // 说明是偶数个 last 需要往后走一个 才能达到需要逆转的list的结尾
        if (fast != null) {
            ListNode next = last.next;
            last.next = null;
            last = next;
        }
        // 如果是 奇数个点的话 那么最后两个 list 的尾巴上的点应该是同一个
        // 如果是偶数个点的话 需要把 last 的置位null 因为他们尾巴不是同一个点
        // 反转 后边半部分
        ListNode reverseListHead = null;
        while (last != null) {
            ListNode next = last.next;
            last.next = reverseListHead;
            reverseListHead = last;
            last = next;
        }

        // 进行比较
        while (head != null && reverseListHead != null) {
            if (head.val != reverseListHead.val) return false;
            head = head.next;
            reverseListHead = reverseListHead.next;
        }
        return true;
    }
}
