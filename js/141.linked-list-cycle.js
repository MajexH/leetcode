/*
 * @lc app=leetcode id=141 lang=javascript
 *
 * [141] Linked List Cycle
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

// @lc code=start
/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
  if (head === null || head.next === null) return false
  let fast = head.next, last = head
  while (fast !== last) {
    last = last.next
    if (fast === null || fast.next === null) return false
    fast = fast.next.next
  }
  return true
};
// @lc code=end

