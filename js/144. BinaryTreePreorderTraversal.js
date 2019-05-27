function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function(root) {
  if (!root) return []
  let res = [], stack = []
  stack.push(root)
  while (stack.length !== 0) {
    let item = stack.pop()
    res.push(item.val)
    if (item.right) stack.push(item.right)
    if (item.left) stack.push(item.left)
  }
  return res
};

let root = new TreeNode(1)
root.left = new TreeNode(3)
root.right = new TreeNode(2)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(5)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(7)

console.log(preorderTraversal(null))
