function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  let result = [], queue = [], temp = [];
  if (root === null) return result
  queue.push(root)
  queue.push(new TreeNode("null"))
  while (queue.length !== 0) {
    let item = queue.shift();
    if (item.val === "null") {
      result.push(JSON.parse(JSON.stringify(temp)))
      // 防止重复添加NULL 因为queue里面只剩null时 会死循环 重复添加null
      if (queue.length === 0) break; 
      queue.push(new TreeNode("null"))
      temp = [];
      continue;
    } else {
      temp.push(item.val)
    }
    if (item.left !== null)
      queue.push(item.left)
    if (item.right !== null)
      queue.push(item.right)
  }
  return result;
};

let treeNode = new TreeNode(3)
treeNode.right = new TreeNode(9)
treeNode.left = new TreeNode(20)
treeNode.left.left = new TreeNode(15)
treeNode.left.right = new TreeNode(7)

console.log(levelOrder(treeNode))