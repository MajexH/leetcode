function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {boolean}
 */
var hasPathSum = function(root, sum) {
  // 采用DFS来做
  let stack = [], pre = new TreeNode(0);
  if (!root) return false;
  // 用val去记住当前已经计算完的sum值
  stack.push({
    node: root,
    val: root.val
  });
  while (stack.length !== 0) {
    let current = stack.pop(), item = current.node, val = current.val;
    if (!item.left && !item.right && val === sum) {
      return true
    }
    if (item.left) {
      stack.push({
        node: item.left,
        val: val + item.left.val
      })
    }
    if (item.right) {
      stack.push({
        node: item.right,
        val: item.right.val + val
      })
    }
  }
  return false;
};

let treeNode = new TreeNode(5)
treeNode.left = new TreeNode(4)
treeNode.right = new TreeNode(8)
treeNode.left.left = new TreeNode(11)
treeNode.left.left.left = new TreeNode(7)
treeNode.left.left.right = new TreeNode(2)
treeNode.right.left = new TreeNode(13)
treeNode.right.right = new TreeNode(4)
treeNode.right.right.right = new TreeNode(1)

console.log(hasPathSum(treeNode, 22))