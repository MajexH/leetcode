function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
  let set = new Set()
  while (head) {
    if (set.has(head))
      return head
    else
      set.add(head)
    head = head.next
  }
  return null
};

let head = new ListNode(3)
head.next = new ListNode(2)
head.next.next = new ListNode(0)
head.next.next.next = new ListNode(-4)
head.next.next.next.next = head.next

console.log(detectCycle(head))