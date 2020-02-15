function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 判断 subTree 是否是 root 的一个子结构
 * 即判断 root 中 是否有一部分与 subTree 完全重合
 * @param {TreeNode} root 
 * @param {TreeNode} subTree 
 * @returns {boolean}
 */
function checkSubTree(root, subTree) {
  if (!root || !subTree) return false
  // 找到一个
  if (root.val === subTree.val)
    if (recursion(root, subTree)) 
    return true
  return checkSubTree(root.left, subTree) || checkSubTree(root.right, subTree)
}

/**
 * 
 * @param {TreeNode} rootNode 
 * @param {TreeNode} subTree 
 * @returns {boolean}
 */
function recursion(rootNode, subTree) {
  if (!rootNode && subTree)
    return false
  // 如果subTree已经访问完了 说明前面的已经匹配
  if (!subTree) return true
  if (rootNode.val !== subTree.val) return false
  return recursion(rootNode.left, subTree.left) && recursion(rootNode.right, subTree.right)
}

let root = new TreeNode(8)
root.left = new TreeNode(8)
root.right = new TreeNode(7)

root.left.left = new TreeNode(9)
root.left.right = new TreeNode(2)
root.left.right.left = new TreeNode(4)
root.left.right.right = new TreeNode(7)

let subTree = new TreeNode(8)
subTree.left = new TreeNode(9)
subTree.right = new TreeNode(2)

console.log(checkSubTree(root, subTree))