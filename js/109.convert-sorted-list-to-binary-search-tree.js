/*
 * @lc app=leetcode id=109 lang=javascript
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

function ListNode(val) {
  this.val = val;
  this.next = null;
}

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * @param {ListNode} head
 * @return {TreeNode}
 */
var sortedListToBST = function(head) {
  let array = []
  while (head) {
    array.push(head.val)
    head = head.next
  }
  return recursion(array, 0, array.length - 1)
};

function recursion(array, start, end) {
  if (start > end) return null
  let mid = Math.floor((start + end) / 2)
  let node = new TreeNode(array[mid])
  node.left = recursion(array, start, mid - 1)
  node.right = recursion(array, mid + 1, end)
  return node
}
// @lc code=end

