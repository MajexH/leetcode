function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * inplace的方法 修改root成为其镜像
 * 其镜像实际上就是左右子树的递归交换
 * @param {TreeNode} root 
 */
function getMirrorTreeInplace(root) {
  if (!root) return

  let temp = root.left
  root.left = root.right
  root.right = temp

  getMirrorTreeInplace(root.left)
  getMirrorTreeInplace(root.right)
}

/**
 * 输入一个根节点为root的树 输出它的镜像
 * @param {TreeNode} root
 * @returns {TreeNode} 
 */
function getMirrorTree(root) {
  return recursion(root)
}

/**
 * 递归的构建镜像树
 * @param {TreeNode} root 
 */
function recursion(root) {
  if (!root) return null
  let node = new TreeNode(root.val)
  node.left = recursion(root.right)
  node.right = recursion(root.left)
  return node
}

let root = new TreeNode(8)

root.left = new TreeNode(6)
root.right = new TreeNode(10)

root.left.left = new TreeNode(5)
root.left.right = new TreeNode(7)

root.right.left = new TreeNode(9)
root.right.right = new TreeNode(11)

// console.log(getMirrorTree(root))
getMirrorTreeInplace(root)
console.log(root)