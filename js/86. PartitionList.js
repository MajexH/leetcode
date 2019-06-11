function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
var partition = function(head, x) {
  let a = new ListNode(0), b = a, c = new ListNode(0), d = c
  while (head) {
    if (head.val < x) {
      b.next = new ListNode(head.val)
      b = b.next
    } else {
      d.next = new ListNode(head.val)
      d = d.next
    }
    head = head.next
  }
  d.next = null
  b.next = c.next
  return a.next
};

let root = new ListNode(1)
root.next = new ListNode(4)
root.next.next = new ListNode(3)
root.next.next.next = new ListNode(2)
root.next.next.next.next = new ListNode(5)
root.next.next.next.next.next = new ListNode(2)

console.log(partition(root, 3))