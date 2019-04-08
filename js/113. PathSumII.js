function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * 非递归实现需要用三个栈来实现DFS
 * 一个栈来保存原始节点的变动情况
 * 一个栈来保存原始节点的sum结果
 * 一个栈来保存当前到这个节点的路径
 * 其实就是模拟了递归调用的栈 因为递归调用必须有这几个参数 所有会有这几个栈来保存
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum1 = function(root, sum) {
  // dfs
  let stack = [], result = [], record = [], pathStack = []
  if (!root) return result
  stack.push(root)
  record.push(JSON.parse(JSON.stringify(root)))
  pathStack.push([])
  while (stack.length !== 0) {
    let item = record.pop();
    let origin = stack.pop();
    let path = JSON.parse(JSON.stringify(pathStack.pop()));
    path.push(origin.val);
    if (!item.left && !item.right) {
      if (item.val === sum) {
        result.push(path)
      }
    }
    if (item.left) {
      item.left.val += item.val
      record.push(item.left)
      stack.push(origin.left)
      pathStack.push(path)
    }
    if (item.right) {
      item.right.val += item.val
      record.push(item.right)
      stack.push(origin.right)
      pathStack.push(path)
    }
    console.log(pathStack)
  }
  return result
};

/**
 * 这次采用递归实现
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number[][]}
 */
var pathSum = function (root, sum) {
  let result = [];
  if (!root) return result
  recursion(root, sum, [], result);
  return result;
}

/**
 * 递归的具体实现
 * @param {TreeNode} root 
 * @param {Number} sum 
 * @param {Array} path 
 * @param {Array} result 
 */
function recursion (root, sum, path, result) {
  path.push(root.val)
  if (root.left) {
    recursion(root.left, sum - root.val, path, result);
  } 
  if (root.right) {
    recursion(root.right, sum - root.val, path, result);
  }
  if (!root.left && !root.right && root.val === sum) {
    result.push(JSON.parse(JSON.stringify(path)));
    path.pop();
    return
  }
  // 为了在不是叶子节点 或者 是叶子节点 但是 sum不等的情况下吧最开始push的给pop掉
  path.pop();
}


let treeNode = new TreeNode(5)
treeNode.left = new TreeNode(4)
treeNode.right = new TreeNode(8)
treeNode.left.left = new TreeNode(11)
treeNode.left.left.left = new TreeNode(7)
treeNode.left.left.right = new TreeNode(2)
treeNode.right.left = new TreeNode(13)
treeNode.right.right = new TreeNode(4)
treeNode.right.right.right = new TreeNode(1)

console.log(pathSum(treeNode, 22))