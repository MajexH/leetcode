function ListNode(val) {
  this.val = val;
  this.next = null;
}


/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
  return recursion(head, new Set())
};

/**
 * 
 * @param {ListNode} node 
 * @param {Set} marked 
 */
function recursion(node, marked) {
  if (!node) return false
  if (marked.has(node)) {
  // 说明已经是第二次访问的了
    return true
  }
  // 说明是第一次访问
    marked.add(node)
    return false || recursion(node.next, marked)
}

let head = new ListNode(3)
head.next = new ListNode(2)
head.next.next = new ListNode(0)
head.next.next.next = new ListNode(-4)


console.log(hasCycle(head))