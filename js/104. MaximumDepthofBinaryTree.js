function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

function treeMaxDepth(node, level) {
  if (!node) 
    return level;
  else
    return Math.max(treeMaxDepth(node.left, level), treeMaxDepth(node.right, level)) + 1;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root) {
  return treeMaxDepth(root, 0)
};

let treeNode = new TreeNode(3)
treeNode.right = new TreeNode(9)
treeNode.left = new TreeNode(20)
treeNode.left.left = new TreeNode(15)
treeNode.left.right = new TreeNode(7)
treeNode.left.left.left = new TreeNode(13);

console.log(maxDepth(treeNode))