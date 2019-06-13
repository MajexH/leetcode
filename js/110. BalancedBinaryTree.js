function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
  if (!root) return true
  let left = depth(root.left)
  let right = depth(root.right)
  if (Math.abs(left - right) > 1) return false
  else return true && isBalanced(root.left) && isBalanced(root.right)
};

function depth(node) {
  if (!node) return 0
  return Math.max(depth(node.left), depth(node.right)) + 1
}

let root = new TreeNode(3)
root.left = new TreeNode(9)
root.right = new TreeNode(20)
root.right.left = new TreeNode(15)
root.right.right = new TreeNode(7)
root.right.right.left = new TreeNode(10)
root.right.right.right = new TreeNode(11)

console.log(isBalanced(root))