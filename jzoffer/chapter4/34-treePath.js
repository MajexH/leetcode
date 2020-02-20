function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}
/**
 * 找到二叉树中和为target的所有路径 路径是指所有从根节点到叶子节点的值
 * 并返回
 * @param {TreeNode} root 
 * @param {number} target 
 * @returns {number[][]}
 */
function getTreePath(root, target) {
  let res = []
  if (!root) return res
  recursion(root, target, res, [])
  return res
}

/**
 * 
 * @param {TreeNode} root 
 * @param {number} target 
 * @param {number[][]} res 
 * @param {number[]} temp 
 */
function recursion(root, target, res, temp) {
  temp.push(root.val)
  if (!root.left && !root.right) {
    if (temp.reduce((pre, cur) => pre + cur) === target) {
      res.push([...temp])
    }
    temp.pop()
    return
  }
  if (root.left) {
    recursion(root.left, target, res, temp)
  }
  if (root.right) {
    recursion(root.right, target, res, temp)
  }
  temp.pop()
}

let root = new TreeNode(10)
root.left = new TreeNode(5)
root.right = new TreeNode(12)
root.left.left = new TreeNode(4)
root.left.right = new TreeNode(7)

console.log(getTreePath(root, 22))