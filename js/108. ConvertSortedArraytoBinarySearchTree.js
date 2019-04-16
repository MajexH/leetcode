function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums) {
  return recurion(nums, 0, nums.length - 1)
};

function recurion (nums, start, end) {
  if (start > end) return null
  let mid = Math.floor((start + end) / 2)
  let node = new TreeNode(nums[mid])
  node.left = recurion(nums, start, mid - 1)
  node.right = recurion(nums, mid + 1, end)
  return node
}