/*
 * @lc app=leetcode id=203 lang=javascript
 *
 * [203] Remove Linked List Elements
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

// @lc code=start

/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
  let pre = new ListNode(0), record = pre
  pre.next = head
  let temp = head
  while (temp) {
    if (temp.val === val) {
      if (temp.next !== null) {
        temp.val = temp.next.val
        temp.next = temp.next.next
      } else {
        pre.next = null
        temp = null
      }
    } else {
      pre = pre.next
      temp = temp.next
    }
  }
  return record.next
};
// @lc code=end

let node = new ListNode(1)
node.next = new ListNode(1)
// node.next.next = new ListNode(6)
// node.next.next.next = new ListNode(3)
// node.next.next.next.next = new ListNode(4)
// node.next.next.next.next.next = new ListNode(5)
// node.next.next.next.next.next.next = new ListNode(6)

console.log(removeElements(node, 1))