function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isValidBST = function(root) {
  return recursion(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER)
};

/**
 * 
 * @param {TreeNode} root 
 * @param {number} low 用来记录当前的最小值
 * @param {number} max 用来记录当前的最大值
 */
function recursion(root, low, max) {
  if (!root) return true
  if (root.val < max && root.val > low)
    return true && recursion(root.left, low, root.val) && recursion(root.right, root.val, max)
  return false
}

let root = new TreeNode(5)
root.left = new TreeNode(1)
root.right = new TreeNode(4)
root.right.left = new TreeNode(3)
root.right.right = new TreeNode(6)

console.log(isValidBST(root))