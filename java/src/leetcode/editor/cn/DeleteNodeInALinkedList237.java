//请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。 
//
// 题目数据保证需要删除的节点 不是末尾节点 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,5,1,9], node = 5
//输出：[4,1,9]
//解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
// 
//
// 示例 2： 
//
// 
//输入：head = [4,5,1,9], node = 1
//输出：[4,5,9]
//解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [2, 1000] 
// -1000 <= Node.val <= 1000 
// 链表中每个节点的值都是 唯一 的 
// 需要删除的节点 node 是 链表中的节点 ，且 不是末尾节点 
// 
// Related Topics 链表 👍 1155 👎 0


package src.leetcode.editor.cn;

public class DeleteNodeInALinkedList237 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        Solution solution = new DeleteNodeInALinkedList237().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}