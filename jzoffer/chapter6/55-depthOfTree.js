function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}


/**
 * 
 * @param {TreeNode} root 
 */
function deepthOfTree(root) {
  return recursion(root)
}

function recursion(root) {
  if (!root) return 0
  return Math.max(recursion(root.left), recursion(root.right)) + 1
}

let root = new TreeNode(5)
root.left = new TreeNode(3)
root.right = new TreeNode(7)
root.left.left = new TreeNode(2)
root.left.right = new TreeNode(4)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(8)
root.right.right.right = new TreeNode(10)

console.log(deepthOfTree(root))