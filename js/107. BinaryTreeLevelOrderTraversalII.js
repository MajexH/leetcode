function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom1 = function(root) {
  if (!root) return []
  let queue = [], res = [], temp = []
  queue.push(root)
  queue.push(new TreeNode('null'))
  while(queue.length) {
    let item = queue.shift()
    if (item.val === 'null') {
      // 说明这一层结束了
      res.push(JSON.parse(JSON.stringify(temp)))
      temp = []
      if (queue.length) queue.push(new TreeNode('null'))
      continue
    }
    if (item.left) queue.push(item.left)
    if (item.right) queue.push(item.right)
    temp.push(item.val)
  }
  return res.reverse()
};


/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
  let res = [], deep = deepth(root)
  for (let i = 0; i < deep; i++) {
    res[i] = new Array()
  }
  recursion(root, 0, res, deep - 1)
  return res
};

function deepth(root) {
  if (!root) return 0
  return Math.max(deepth(root.left), deepth(root.right)) + 1
}

/**
 * 
 * @param {TreeNode} node 
 * @param {number} level 
 * @param {Array} res 
 * @param {number} deep
 */
function recursion(node, level, res, deep) {
  if (!node) return
  recursion(node.left, level + 1, res, deep)
  recursion(node.right, level + 1, res, deep)
  res[deep - level].push(node.val)
}

let treeNode = new TreeNode(3)
treeNode.left = new TreeNode(9)
treeNode.right = new TreeNode(20)
treeNode.right.left = new TreeNode(15)
treeNode.right.right = new TreeNode(7)

console.log(levelOrderBottom(treeNode))