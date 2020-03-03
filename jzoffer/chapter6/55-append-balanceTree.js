function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 判断以root为根节点的树 是否是平衡二叉树
 * @param {TreeNode} root 
 */
function checkBalanceTree(root) {
  let map = new Map()
  return recursion(root, map)
}

/**
 * 后序遍历的话 可以先访问 子节点 再访问 父节点 因此不会出现重复访问的情况
 * @param {TreeNode} root 
 */
function checkBalanceTreeWithOutMemo(root) {
  return lastOrderTravel(root, { val: 1 })
}

// 用deep.val来保存每个节点的长度
function lastOrderTravel(root, depth) {
  if (!root) {
    depth.val = 0
    return true
  }
  let left = { val: 0 }, right = { val: 0 }
  // 后续遍历 先去访问 两个子节点 再访问自己
  if (lastOrderTravel(root.left, left) && lastOrderTravel(root.right, right)) {
    if (Math.abs(left.val - right.val) <= 1) {
      depth.val = Math.max(left.val, right.val) + 1
      return true
    }
  }
  return false
}

// 只是用memo来保存每个节点高度的做法
// 因为getCout会去重复访问 节点
function recursion(root, memo) {
  if (!root) return true
  let left = getCount(root.left, memo)
  let right = getCount(root.right, memo)
  if (Math.abs(left - right) > 1) return false
  return recursion(root.left, memo) && recursion(root.right, memo)
}


function getCount(node, memo) {
  if (!node) return 0
  if (memo.has(node)) return memo.get(node)
  memo.set(node, Math.max(getCount(node.left, memo), getCount(node.right, memo)) + 1)
  return memo.get(node)
}

let root = new TreeNode(5)
root.left = new TreeNode(3)
root.right = new TreeNode(7)
root.left.left = new TreeNode(2)
root.left.right = new TreeNode(4)
root.right.left = new TreeNode(6)
root.right.right = new TreeNode(8)
root.right.right.right = new TreeNode(10)
// root.right.right.right.right = new TreeNode(12)

console.log(checkBalanceTree(root))
console.log(checkBalanceTreeWithOutMemo(root))