function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(root, k) {
  // 小于等于当前节点的节点数
  let number = count(root.left) + 1
  if (number > k) {
    // 意味着k个最小的在左边
    return  kthSmallest(root.left, k)
  } else if (number < k) {
    // 意味着k个最小的在右边 递归右子树的时候 相当于去掉了左边和顶上的节点数量
    return kthSmallest(root.right, k - number)
  } else {
    // k === left
    return root.val
  }
};


/**
 * 获取node下所有节点的个数
 * @param {TreeNode} node 
 */
function count(node) {
  if (!node) return 0
  return count(node.left) + count(node.right) + 1
}

let root = new TreeNode(3)
root.left = new TreeNode(1)
root.right = new TreeNode(4)
root.left.right = new TreeNode(2)

console.log(kthSmallest(root, 4))