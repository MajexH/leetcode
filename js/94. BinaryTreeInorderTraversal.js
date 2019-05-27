function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var inorderTraversal = function(root) {
  if (!root) return []
  let stack = [], res = []
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      res.push(root.val)
      root = root.right
    }
  }
  return res
}

let root = new TreeNode(1)
root.left = new TreeNode(3)
root.right = new TreeNode(2)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(5)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(7)

console.log(inorderTraversal(root))
