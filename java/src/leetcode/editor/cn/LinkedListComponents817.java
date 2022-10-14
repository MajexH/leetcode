//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。 
//
// 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [0,1,2,3], nums = [0,1,3]
//输出: 2
//解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。 
//
//
// 示例 2： 
//
// 
//
// 
//输入: head = [0,1,2,3,4], nums = [0,3,1,4]
//输出: 2
//解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为n 
// 1 <= n <= 10⁴ 
// 0 <= Node.val < n 
// Node.val 中所有值 不同 
// 1 <= nums.length <= n 
// 0 <= nums[i] < n 
// nums 中所有值 不同 
// 
//
// Related Topics 数组 哈希表 链表 👍 169 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class LinkedListComponents817 {
    public static void main(String[] args) {
        Solution solution = new LinkedListComponents817().new Solution();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numComponents(ListNode head, int[] nums) {

            Set<Integer> memo = new HashSet<>();

            for (int num : nums) {
                memo.add(num);
            }

            int res = 0;

            while (head != null) {

                if (!memo.contains(head.val)) {
                   head = head.next;
                   continue;
                }
                // 移动 head 和 memo
                while (head != null && memo.contains(head.val)) {
                    // 不用 remove 因为数字是唯一的 head 已经向后走了
                    //memo.remove(head.val);
                    head = head.next;
                }
                res++;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}