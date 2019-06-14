function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
function invertTree(root) {
  recursion(root)
  return root
}

function recursion(root) {
  if (!root) return
  recursion(root.left)
  recursion(root.right)
  let temp = root.right
  root.right = root.left
  root.left = temp
}


let root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(5)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(7)

invertTree(root)
console.log(root)