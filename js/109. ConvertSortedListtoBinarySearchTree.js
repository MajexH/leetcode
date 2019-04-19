function ListNode(val) {
  this.val = val;
  this.next = null;
}

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
  let temp = []
  while (head) {
    temp.push(head.val)
    head = head.next
  }
  return recursion(temp, 0, temp.length - 1)
};

function recursion(nums, start, end) {
  if (start > end) return null
  let mid = Math.floor((start + end) / 2)
  let node = new TreeNode(nums[mid])
  node.left = recursion(nums, start, mid - 1)
  node.right = recursion(nums, mid + 1, end)
  return node
}

let node = new ListNode(-10)
node.next = new ListNode(-3)
node.next.next = new ListNode(0)
node.next.next.next = new ListNode(5)
node.next.next.next.next = new ListNode(9)

console.log(sortedListToBST(node))