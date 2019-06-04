function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * 先访问right right right 在right呗访问完的时候 访问左边
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideViewRecursion = function(root) {
  let rootDepth = depth(root), memo = Array(rootDepth + 1).fill(Number.MIN_SAFE_INTEGER)
  dfsRecursion(root, memo, 0)
  memo.pop()
  return memo
};

/**
 * 先访问right right right 在right呗访问完的时候 访问左边
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
  return dfs(root)
};

/**
 * 得到当前的高度
 * @param {TreeNode} node 
 */
function depth(node) {
  if (!node) return 0
  return Math.max(depth(node.left), depth(node.right)) + 1
}

/**
 * 递归实现的
 * @param {TreeNode} node 
 * @param {boolean[]} memo 
 * @param {number} depth
 */
function dfsRecursion(node, memo, depth) {
  if (!node) return
  // 当前节点已经访问过了
  if (memo[depth] === Number.MIN_SAFE_INTEGER) {
    memo[depth] = node.val
  }
  // depth表示当前的深度
  dfs(node.right, memo, depth + 1)
  dfs(node.left, memo, depth + 1)
  return
}

/**
 * 非递归实现
 */
function dfs(root) {
  if (!root) return []
  let rootDepth = depth(root), res = Array(rootDepth + 1).fill(Number.MIN_SAFE_INTEGER)
  let stack = [], levelStack = []
  levelStack.push(0)
  stack.push(root)
  while (stack.length !== 0) {
    let top = stack.pop(), level = levelStack.pop()
    if (top.left) {
      stack.push(top.left)
      levelStack.push(level + 1)
    }
    if (top.right) {
      stack.push(top.right)
      levelStack.push(level + 1)
    }
    if (res[level] === Number.MIN_SAFE_INTEGER) {
      res[level] = top.val
    }
  }
  res.pop()
  return res
}

let root = new TreeNode(1)
root.left = new TreeNode(2)
root.left.left = new TreeNode(4)
root.left.left.right = new TreeNode(7)
root.left.left.right.right = new TreeNode(9)
root.left.left.right.right.right = new TreeNode(10)
root.left.right = new TreeNode(5)

root.right = new TreeNode(3)
root.right.right = new TreeNode(6)
root.right.right.left = new TreeNode(8)

console.log(rightSideView(null))