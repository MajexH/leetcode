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
  let stack = [];
  if (!root) return false;
  stack.push(root);
  while (stack.length !== 0) {
    let item = stack.pop();
    if (!item.left && !item.right && item.val === sum) {
      return true
    }
    if (item.left) {
      item.left.val = item.val + item.left.val
      stack.push(item.left)
    }
    if (item.right) {
      item.right.val = item.val + item.right.val
      stack.push(item.right)
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