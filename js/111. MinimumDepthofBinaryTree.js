function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth1 = function(root) {
  let queue = [];
  let min = 0;
  if (root === null) return min;
  queue.unshift(root)
  queue.push(new TreeNode('null'))
  min++;
  while (queue.length !== 0) {
    let item = queue.shift()
    if (item.val === 'null') {
      min++;
      if (queue.length === 0) break; 
      // 加入特殊标记 表示 这一层 已经完了
      queue.push(new TreeNode('null'))
      continue; 
    }
    if (item.left === null && item.right === null) {
      return min;
    }
    if (item.left !== null)
      queue.push(item.left)
    if (item.right !== null)
      queue.push(item.right) 
  }
  return min;
};

/**
 * @param {TreeNode} root
 * @return {number}
 */
var minDepth = function(root) {
  return recursion(root)
};

function recursion(root) {
  if (!root) return 0
  let left = recursion(root.left), right = recursion(root.right)
  if (left === 0)
    return right + 1
  if (right === 0)
    return left + 1
  return Math.min(left, right) + 1
}

let treeNode = new TreeNode(3)
treeNode.right = new TreeNode(9)
treeNode.left = new TreeNode(20)
treeNode.left.left = new TreeNode(15)
treeNode.left.right = new TreeNode(7)

console.log(minDepth(treeNode))