function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 因为 bst 的中序遍历是 递增的
 * 因此用中序遍历来做
 * 找到第k到的一个数
 * @param {TreeNode} root 
 * @param {Number} k 
 */
function findKthNodeInBst(root, k) {
  if (!root || k === 0) return null
  return inOrderTravel(root, k)
}

/**
 * 中序遍历
 * @param {TreeNode} root 
 * @param {Number} k 
 */
function inOrderTravel(root, k) {
  let stack = []
  while (root || stack.length !== 0) {
    while (root) {
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      if (k === 1) return root
      else k--
      root = root.right
    }
  }
  return null
}


let root = new TreeNode(5)
root.left = new TreeNode(3)
root.right = new TreeNode(7)
root.left.left = new TreeNode(2)
root.left.right = new TreeNode(4)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(8)

console.log(findKthNodeInBst(root, 1))