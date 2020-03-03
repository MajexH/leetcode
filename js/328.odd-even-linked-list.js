/*
 * @lc app=leetcode id=328 lang=javascript
 *
 * [328] Odd Even Linked List
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
var oddEvenList = function(head) {
  if (!head) return head
  let remember = new ListNode(0)
  remember.next = head

  let tempOdd = head, tempEven = head.next, even = tempEven, odd = tempOdd
  while (tempEven !== null && tempOdd !== null) {
    tempOdd.next = tempEven.next
    tempOdd = tempOdd.next
    if (tempOdd !== null) {
      odd = tempOdd
      tempEven.next = tempOdd.next
      tempEven = tempEven.next
    }
  }
  odd.next = even
  return remember.next
};

// @lc code=end
let list = new ListNode(1)
list.next = new ListNode(2)
list.next.next = new ListNode(3)
list.next.next.next = new ListNode(4)
list.next.next.next.next = new ListNode(5)

console.log(oddEvenList(list))
console.log()