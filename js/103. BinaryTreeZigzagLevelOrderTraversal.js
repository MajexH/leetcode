function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {
  // indicate push from left to right
  // otherwise from right to left
  let left = true;
  let queue = [], result = [], temp = []
  if (!root) return result
  queue.push(root)
  queue.push(new TreeNode('null'))
  while (queue.length !== 0) {
    let item = queue.shift();
    if (item.val === 'null') {
      // 表示这一层结束了，而且 新的一层已经加入 所以 需要push一个新的标识符
      result.push(JSON.parse(JSON.stringify(left ? temp: temp.reverse())))
      temp = []
      left = !left
      if (queue.length === 0) break;
      queue.push(new TreeNode('null')); 
      continue;
    }
    temp.push(item.val)
    if (item.left !== null)
      queue.push(item.left)
    if (item.right !== null)
      queue.push(item.right)
  }
  return result;
};

let treeNode = new TreeNode(1)
treeNode.right = new TreeNode(3)
treeNode.left = new TreeNode(2)
treeNode.left.left = new TreeNode(4)
treeNode.right.right = new TreeNode(5)

console.log(zigzagLevelOrder(treeNode))