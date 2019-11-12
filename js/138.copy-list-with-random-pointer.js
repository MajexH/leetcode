/*
 * @lc app=leetcode id=138 lang=javascript
 *
 * [138] Copy List with Random Pointer
 */
class Node {
  constructor(val, next, random) {
    this.val = val;
    this.next = next;
    this.random = random;
  }
}
;

// @lc code=start
/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
  if (!head) return null
  let map = new Map()
  let newHead = new Node(head.val, head.next, head.random), temp = newHead, origin = head
  map.set(head.val, temp)
  head = head.next

  while (head) {
    temp.next = new Node(head.val, head.next, null)
    temp = temp.next
    head = head.next
    map.set(temp.val, temp)
  }

  temp = newHead

  while (origin) {
    if (origin.random)
      temp.random = map.get(origin.random.val)
    else
      temp.random = null
    temp = temp.next
    origin = origin.next
  }

  return newHead
};
// @lc code=end

let node = new Node(1, null, null)
node.next = new Node(2, null, null)
node.random = node.next
node.next.random = node.next

console.log(copyRandomList(node))