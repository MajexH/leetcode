function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
  let array = []
  while (head) {
    array.push(head)
    head = head.next
  }
  let res = new ListNode(0), pre = res
  for (let i = array.length - 1; i >= 0; i--) {
    pre.next = array[i]
    pre = pre.next
  }
  pre.next = null
  return res.next
};

let root = new ListNode(1)
root.next = new ListNode(2)
root.next.next = new ListNode(3)
root.next.next.next = new ListNode(4)
root.next.next.next.next = new ListNode(5)

console.log(reverseList(root))