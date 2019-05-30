function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
  let stack = [], res = []
  while (root || stack.length !== 0) {
    while (root) {
      root.flag = false
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      if (root.flag) {
        // 说明是第二次弹出
        res.push(root.val)
        root = null
      } else {
        // 说明是第一次弹出
        root.flag = true
        stack.push(root)
        root = root.right
      }
    }
  }
  return res
};

let root = new TreeNode(1)
root.left = new TreeNode(3)
root.right = new TreeNode(2)
// root.left.left = new TreeNode(4)
// root.left.right = new TreeNode(5)
// root.right.left = new TreeNode(6)
// root.right.right = new TreeNode(7)

console.log(postorderTraversal(root))
