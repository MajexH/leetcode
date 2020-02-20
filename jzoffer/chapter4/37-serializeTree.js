function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

/**
 * 序列化root 最后的结果按照 前序遍历
 * 其中null节点用$表示
 * @param {TreeNode} root 
 */
function serializeTree(root) {
  let res = {
    str: ''
  }
  preOrder(root, res)
  return res.str
}

function preOrder(root, res) {
  if (!root) {
    res.str += '$,'
    return
  }
  res.str += root.val + ','
  preOrder(root.left, res)
  preOrder(root.right, res)
}

/**
 * 反序列化 将序列化出来的 str 反序列化成树
 * @param {String} str 
 * @returns {TreeNode}
 */
function deserializeTree(str) {
  return recursion(str, 0).node
}

/**
 * 
 * @param {String} str 
 * @param {number} start 
 */
function recursion(str, start) {
  
  if (start >= str.length) {
    return
  }
  if (str.charAt(start) === '$') {
    return { 
      node: null,
      index: start
    }
  }
  if (str.charAt(start) === ',') {
    return recursion(str, start + 1)
  }

  let node = new TreeNode(str.charAt(start))
  // 去遍历right的时候 需要知道 left最后 到了哪个点儿了
  let leftRes = recursion(str, start + 1)
  node.left = leftRes.node
  let rightRes = recursion(str, leftRes.index + 1)
  node.right = rightRes.node
  return {
    node,
    index: rightRes.index
  }
}

let root = new TreeNode(1)
root.left = new TreeNode(2)
root.right = new TreeNode(3)

root.left.left = new TreeNode(4)
root.right.left = new TreeNode(5)
root.right.right = new TreeNode(6)

console.log(serializeTree(root))

console.log(deserializeTree(serializeTree(root)))