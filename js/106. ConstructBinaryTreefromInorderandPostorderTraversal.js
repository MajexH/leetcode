function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {number[]} inorder
 * @param {number[]} postorder
 * @return {TreeNode}
 */
var buildTree = function(inorder, postorder) {
  if (inorder.length === 0)
    return null
  if (inorder.length === 1)
    return new TreeNode(inorder[0])
  let root = new TreeNode(postorder.pop()), index = inorder.findIndex(val => val === root.val)
  root.left = buildTree(inorder.slice(0, index), postorder.slice(0, index))
  root.right = buildTree(inorder.slice(index + 1, inorder.length), postorder.slice(index, postorder.length))
  return root
};

console.log(buildTree([4, 2, 5, 1, 6, 3, 7], [4, 5, 2, 6, 7, 3, 1]))