/*
 * @lc app=leetcode id=19 lang=javascript
 *
 * [19] Remove Nth Node From End of List
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

// @lc code=start

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
  // 添加头结点是为了防止删除的是正向第一个
  let add = new ListNode(0), fast = head, last = add
  add.next = head
  let counter = 0
  while (fast !== null) {
    if (counter >= n)
      last = last.next
    fast = fast.next
    counter++
  }
  last.next = last.next.next
  return add.next
};
// @lc code=end

