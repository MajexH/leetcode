function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

function max(node, level) {
  if (!node) 
    return level;
  else
    return Math.max(max(node.left, level), max(node.right, level)) + 1;
}
/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree1 = function(root) {
  if (!root) {
    return 0
  }
  let left = max(root.left, 0) - 1
  let right = max(root.right, 0) - 1
  return left + right + 2
};
let res;
var diameterOfBinaryTree = function(root) {
  res = 1;
  depth(root);
  return res - 1;
};

function depth(node) {
  if (!node) return 0;
  let l = depth(node.left)
  let r = depth(node.right)
  res = Math.max(res, l + r + 1)
  return Math.max(l, r) + 1
}

let treeNode = new TreeNode(3)
treeNode.left = new TreeNode(9)
treeNode.right = new TreeNode(20)
treeNode.right.left = new TreeNode(15)
treeNode.right.right = new TreeNode(7)
treeNode.right.left.left = new TreeNode(15)
treeNode.right.left.right = new TreeNode(15)
treeNode.right.right.left = new TreeNode(7)
treeNode.right.left.left.left = new TreeNode(15)
treeNode.right.left.right.left = new TreeNode(15)
treeNode.right.left.right.right = new TreeNode(15)
treeNode.right.left.right.right.right = new TreeNode(15)
treeNode.right.left.right.right.right.right = new TreeNode(15)

console.log(diameterOfBinaryTree1(treeNode))