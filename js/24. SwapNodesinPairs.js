function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
  let a = head, pre = null;
  if (!head || !head.next) return head
  while (true) {
    if (a === head) 
      head = head.next
    // swap node pair
    let b = a.next
    if (b !== null) {
      a.next = b.next
      b.next = a
      if (pre) {
        pre.next = b;
      }
    }
    pre = a;
    a = a.next
    // stop condition
    if (!a || !a.next)
      break
  }
  return head
};

let head = new ListNode(1)
head.next = new ListNode(2)
head.next.next = new ListNode(3)
head.next.next.next = new ListNode(4)
head.next.next.next.next = new ListNode(5)
head.next.next.next.next.next = new ListNode(6)

console.log(swapPairs(head))