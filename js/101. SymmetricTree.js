function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * 
 * @param {TreeNode} left 
 * @param {TreeNode} right 
 */
function same(left, right) {
  if (left === null && right === null)
    return true
  if (left === null || right === null)
    return false
  return (left.val === right.val) &&
    same(left.right, right.left) &&
    same(left.left, right.right)
}
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
  return same(root, root)
};

let root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)

console.log(isSymmetric(root))