function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
  let a = new ListNode(0), b = a, counter = 1, array = []
  a.next = head
  while (counter <= n) {
    if (counter > m - 1) {
      array.push(head)
    } else {
      b = b.next
    }
    head = head.next
    counter++;
  }
  for (let i = array.length  - 1; i >= 0; i--) {
    b.next = array[i]
    b = b.next
  }
  b.next = head
  return a.next
};

let node = new ListNode(1)
node.next = new ListNode(2)
node.next.next = new ListNode(3)
node.next.next.next = new ListNode(4)
node.next.next.next.next = new ListNode(5)

console.log(reverseBetween(node, 2, 4))