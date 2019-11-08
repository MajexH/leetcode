
function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
  let res = []
  if (!root) return res
  recursion(res, [], root)
  return res
};

/**
 * 
 * @param {Array} res 
 * @param {Array} temp 
 * @param {TreeNode} node 
 */
function recursion(res, temp, node) {
  // 判断叶子节点
  if (!node.left && !node.right) {
    temp.push(node.val)
    res.push(temp.join('->'))
    return
  }
  temp.push(node.val)
  if (node.left) { 
    recursion(res, temp, node.left)
    temp.pop()
  }
  if (node.right) {
    recursion(res, temp, node.right)
    temp.pop()
  }
}


let root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)
root.left.right = new TreeNode(5)

console.log(binaryTreePaths(root))