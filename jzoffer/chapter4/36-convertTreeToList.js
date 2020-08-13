function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 实现inplace的转换
 * 将一个
 * @param {TreeNode} root 
 */
function convertTreeToList(root) {
  recursion(root)
  // 找到开始节点
  while (root.left) {
    root = root.left
  }
  return root
}

function recursion(root) {
  if (!root) return
  recursion(root.left)
  recursion(root.right)
  // 上一个root要和左子树的 最右子树 相连
  // 其实就是找到左子树的 最右子树 相连
  let cur = root.left
  if (cur) {
    while (cur.right) {
      cur = cur.right
    }
  }
  // 与root相连 形成双向链接
  root.left = cur
  cur.right = root

  // 链接右子树
  cur = root.right
  if (!cur) return
  while (cur.left) {
    cur = cur.left
  }
  root.right = cur
  cur.left = root
}

let root = new TreeNode(10)
root.left = new TreeNode(6)
root.right = new TreeNode(14)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(8)
root.right.left = new TreeNode(12)
root.right.right = new TreeNode(16)

root = convertTreeToList(root)

console.log(root)