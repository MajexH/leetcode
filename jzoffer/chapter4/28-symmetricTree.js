function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 判断一个tree自己是不是 对称的 
 * 即左右子树一样
 * @param {TreeNode} root 
 */
function checkSymmetricTree(root) {
  return recursion(root, root)
}

/**
 * node1和node2都是root的指针
 * @param {TreeNode} node1
 * @param {TreeNode} node2
 */
function recursion(node1, node2) {
  if (!node1 && !node2) return true
  if (!node1 || !node2) return false
  if (node1.val === node2.val) {
    return recursion(node1.left, node2.right) && recursion(node1.right, node2.left)
  }
  return false
}