/*
 * @lc app=leetcode id=24 lang=javascript
 *
 * [24] Swap Nodes in Pairs
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

// @lc code=start
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  let pre = new ListNode(0), last = head, record = pre
  pre.next = head
  while (last && last.next) {
    let temp = last.next.next
    pre.next = last.next
    pre.next.next = last
    pre = last
    last = temp
    pre.next = last
  }
  return record.next
};
// @lc code=end

let head = new ListNode(1)
head.next = new ListNode(2)
head.next.next = new ListNode(3)
head.next.next.next = new ListNode(4)
head.next.next.next.next = new ListNode(5)
// head.next.next.next.next.next = new ListNode(6)

console.log(swapPairs(head))