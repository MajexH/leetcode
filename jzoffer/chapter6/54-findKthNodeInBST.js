function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 找到一个在二叉搜索树中的Kth的节点
 * @param {TreeNode} root 
 */
function findKthNodeInBST(root, k) {
  return recursion(root, k)
}

function recursion(root, target) {
  // 这个情况说明找不到
  if (!root) return null
  let count = getCount(root.left) + 1
  if (target < count) {
  // 说明在左边
    return recursion(root.left, target)  
  } else if (target > count) {
    return recursion(root.right, target - count)
  } else {
    return root
  }
}

function getCount(root) {
  if (!root) return 0
  return getCount(root.left) + getCount(root.right) + 1
}

let root = new TreeNode(5)
root.left = new TreeNode(3)
root.right = new TreeNode(7)
root.left.left = new TreeNode(2)
root.left.right = new TreeNode(4)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(8)

console.log(findKthNodeInBST(root, 10))