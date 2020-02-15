function ListNode(val) {
  this.val = val
  this.next = null
}

/**
 * 将头结点所指的链表 翻转
 * 并返回 反转之后的 头结点
 * @param {ListNode} head 
 * @returns {ListNode}
 */
function reverseList(head) {
  // 只有一个节点的情况 或者没有节点
  if (!head || !head.next) return head
  let pre = head, last = head.next, lastNext = last.next
  // 只有两个节点的情况
  if (lastNext === null) {
    last.next = pre
    pre.next = null
    return last
  }
  while (last.next !== null) {
    last.next = pre
    if (pre === head) pre.next = null
    pre = last
    last = lastNext
    lastNext = last.next
  }
  last.next = pre
  return last
}

let head = new ListNode(1)
head.next = new ListNode(2)
head.next.next = new ListNode(3)
head.next.next.next = new ListNode(4)
head.next.next.next.next = new ListNode(5)
head.next.next.next.next.next = new ListNode(6)

head = reverseList(head)
console.log(head)