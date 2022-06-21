//package leetcode.editor.cn;
//////给你一个链表数组，每个链表都已经按升序排列。
//////
////// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//////
//////
//////
////// 示例 1：
//////
////// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//////输出：[1,1,2,3,4,4,5,6]
//////解释：链表数组如下：
//////[
////// 1->4->5,
////// 1->3->4,
////// 2->6
//////]
//////将它们合并到一个有序链表中得到。
//////1->1->2->3->4->4->5->6
//////
//////
////// 示例 2：
//////
////// 输入：lists = []
//////输出：[]
//////
//////
////// 示例 3：
//////
////// 输入：lists = [[]]
//////输出：[]
//////
//////
//////
//////
////// 提示：
//////
//////
////// k == lists.length
////// 0 <= k <= 10^4
////// 0 <= lists[i].length <= 500
////// -10^4 <= lists[i][j] <= 10^4
////// lists[i] 按 升序 排列
////// lists[i].length 的总和不超过 10^4
//////
////// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 1997 👎 0
////
//
//
////leetcode submit region begin(Prohibit modification and deletion)
//
//import java.util.Objects;
//
///**
// * Definition for singly-linked list.
// * public class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode() {}
// *     ListNode(int val) { this.val = val; }
// *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
//class Solution {
//
//    private static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    private ListNode recursion(ListNode[] lists, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        if (start == end) {
//            return lists[start];
//        }
//        int mid = (start + end) / 2;
//        ListNode left = this.recursion(lists, start, mid);
//        ListNode right = this.recursion(lists, mid + 1, end);
//        return this.merge(left, right);
//    }
//
//    private ListNode merge(ListNode left, ListNode right) {
//        ListNode res = new ListNode(), mv = res;
//
//        while (Objects.nonNull(left) || Objects.nonNull(right)) {
//            if (Objects.isNull(left)) {
//                mv.next = right;
//                break;
//            }
//            if (Objects.isNull(right)) {
//                mv.next = left;
//                break;
//            }
//
//            if (left.val < right.val) {
//                mv.next = left;
//                left = left.next;
//            } else {
//                mv.next = right;
//                right = right.next;
//            }
//            mv = mv.next;
//        }
//
//        return res.next;
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        return this.recursion(lists, 0, lists.length - 1);
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
