function ListNode(val) {
  this.val = val
  this.next = null
}
/**
 * 找到一个链表中的倒数的第k个节点
 * @param {ListNode} head 
 * @param {number} k 
 */
function findTheLastKNodeInList(head, k) {
  let fast = head, last = head, counter = 0
  while (fast) {
    if (counter >= k) {
      last = last.next
    }
    fast = fast.next
    counter++
  }
  // 说明不够长
  if (counter < k) return null
  return last
}

let head = new ListNode(1)
head.next = new ListNode(2)
head.next.next = new ListNode(3)
head.next.next.next = new ListNode(4)
head.next.next.next.next = new ListNode(5)
head.next.next.next.next.next = new ListNode(6)

console.log(findTheLastKNodeInList(head, 3))