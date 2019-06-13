function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
  let counter = 0, temp = [], a = new ListNode(0), b = a;
  while (head) {
    if (counter < k) {
      temp.push(new ListNode(head.val))
      counter++;
      head = head.next;
    } else {
      for (let i = temp.length - 1; i >= 0; i--) {
        b.next = temp[i]
        b = b.next
      }
      temp = []
      counter = 0;
    }
  }
  if (temp.length < k) {
    temp = temp.reverse()
  } 
  for (let i = temp.length - 1; i >= 0; i--) {
    b.next = temp[i]
    b = b.next
  }
  return a.next
};

let node = new ListNode(1)
node.next = new ListNode(2)
node.next.next = new ListNode(3)
node.next.next.next = new ListNode(4)
node.next.next.next.next = new ListNode(5)

console.log(reverseKGroup(node, 2))