function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
  if (!root) return 0
  let total = []
  recursion(root, 0, total)
  return total.pop()
};

let total = 0
/**
 * 也可以用全局变量来保存最后计算的total总值
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers1 = function(root) {
  if (!root) return 0
  total = 0
  recursion(root, 0) // 因为去挂在global下的 所以直接去掉数组保存就行了
  return total
};

/**
 * 
 * @param {TreeNode} node 
 * @param {number} sum sum用来记录每一层的值
 * @param {number[]} total
 */
function recursion(node, sum, total) {
  // 标识当前层次的合的值
  sum = sum * 10 + node.val
  if (!node.left && !node.right) {
    // 算合
    if (total.length === 0) {
      total.push(sum)
    } else {
      total.push(total.pop() + sum)
    }
    return
  }
  if (node.left)
    recursion(node.left, sum, total)
  if (node.right)
    recursion(node.right, sum, total)
  return
}

let root = new TreeNode(4)
root.left = new TreeNode(9)
root.right = new TreeNode(0)
root.left.left = new TreeNode(5)
root.left.right = new TreeNode(1)
console.log(sumNumbers(root))