function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
  if (preorder.length === 0) {
    return null
  }
  if (inorder.length === 1)
    return new TreeNode(inorder[0])
  let root = new TreeNode(preorder[0]), index = inorder.findIndex((val) => {
    return val === root.val
  })
  preorder.shift()
  root.left = buildTree(preorder.slice(0, index), inorder.slice(0, index))
  root.right = buildTree(preorder.slice(index, preorder.length), inorder.slice(index + 1, inorder.length))
  return root
};

console.log(buildTree([], []))