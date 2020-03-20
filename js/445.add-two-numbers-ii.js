/*
 * @lc app=leetcode id=445 lang=javascript
 *
 * [445] Add Two Numbers II
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

// @lc code=start

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
  let stack1 = [], stack2 = []
  while (l1 !== null) {
    stack1.push(l1)
    l1 = l1.next
  }
  while (l2 !== null) {
    stack2.push(l2)
    l2 = l2.next
  }
  let add = 0, last = null
  while (stack1.length !== 0 && stack2.length !== 0) {
    let temp1 = stack1.pop(), temp2 = stack2.pop()
    if (last !== null) {
      temp1.next = last
    }
    let val = temp1.val + temp2.val + add
    temp1.val = val % 10
    add = Math.floor(val / 10) 
    last = temp1
  }
  while (stack1.length !== 0) {
    let temp1 = stack1.pop()
    if (last !== null) {
      temp1.next = last
    }
    let val = temp1.val + add
    temp1.val = val % 10
    add = Math.floor(val / 10) 
    last = temp1
  }
  while (stack2.length !== 0) {
    let temp2 = stack2.pop()
    if (last !== null) {
      temp2.next = last
    }
    let val = temp2.val + add
    temp2.val = val % 10
    add = Math.floor(val / 10) 
    last = temp2
  }
  if (add !== 0) {
    let node = new ListNode(add)
    node.next = last
    last = node
  }
  return last
};
// @lc code=end

let l1 = new ListNode(7)
l1.next = new ListNode(2)
l1.next.next = new ListNode(4)
l1.next.next.next = new ListNode(3)

let l2 = new ListNode(5)
l2.next = new ListNode(6)
l2.next.next = new ListNode(4)

console.log(addTwoNumbers(l2, l1))
console.log(1)