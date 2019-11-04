/*
 * @lc app=leetcode id=234 lang=javascript
 *
 * [234] Palindrome Linked List
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

var isPalindrome1 = function(head) {
  if (head === null) return true
  let stack = [], temp = head
  while (temp.next !== null) {
    stack.push(temp)
    temp = temp.next
  }
  while (head !== temp) {
    if (head.val !== temp.val) return false
    head = head.next
    if (head === temp) break
    temp = stack.pop()
  }
  return true
};

// @lc code=start
/**
 * 上面哪种方法虽然是o(n)的实践 但是却是o(n)的空间 他说要用o(1)的空间
 * 最好就是翻转后面的节点
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
  let fast = head, last = head
  while (fast !== null && fast.next !== null) {
    fast = fast.next.next
    last = last.next
  }
  // 如果是奇数 还要再前进一位
  if (fast) last = last.next
  // 这样就找到最后一个了 现在就只需要翻转后半的链表即可
  let pre = null
  while (last) {
    let next = last.next
    last.next = pre
    pre = last
    last = next
  }
  // 出来之后 pre 是 保存了后面的链表的开始位置
  while (head && pre) {
    if (head.val !== pre.val) return false
    head = head.next
    pre = pre.next
  }
  return true
};
// @lc code=end

let root = new ListNode(1)
root.next = new ListNode(2)
root.next.next = new ListNode(1)
console.log(isPalindrome(root))