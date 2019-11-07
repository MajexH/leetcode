/*
 * @lc app=leetcode id=237 lang=javascript
 *
 * [237] Delete Node in a Linked List
 */


// @lc code=start

/**
 * @param {ListNode} node
 * @return {void} Do not return anything, modify node in-place instead.
 */
var deleteNode = function(node) {
  if (node) {
    node.val = node.next.val
    node.next = node.next.next
  }
};
// @lc code=end

function ListNode(val) {
  this.val = val;
  this.next = null;
}

let head = new ListNode(4)
head.next = new ListNode(5)
head.next.next = new ListNode(1)
head.next.next.next = new ListNode(9)
let node = head.next
deleteNode(node)

console.log(head)