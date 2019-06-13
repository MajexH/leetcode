
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
      if (!root.flag) {
        root.flag = true
        stack.push(root)
        // 如果该节点是第一次访问 也就是还不可以出栈 则访问其右子树
        root = root.right
      } else {
        res.push(root.val)
        // 后序遍历 因为现在已经是第二次访问过了 所以他的左右子树都已经访问完了 所以需要把这个置位null
        root = null
      }
    }
  }
  return res;
};

let root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(5)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(7)

console.log(postorderTraversal(root))


