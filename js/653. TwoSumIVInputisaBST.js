function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
  if (!root) return false
  let queue = [], set = new Set();
  queue.push(root)
  while (queue.length !== 0) {
    let temp = queue.shift();
    console.log(set)
    if (set.has(k - temp.val)) {
      return true
    }
    if (temp.left) queue.push(temp.left)
    if (temp.right) queue.push(temp.right)
    set.add(temp.val)
  }
  return false
};

let node = new TreeNode(1)
// node.left = new TreeNode(3)
// node.right = new TreeNode(6)
// node.left.left = new TreeNode(2)
// node.left.right = new TreeNode(4)
// node.right.right = new TreeNode(7)

console.log(findTarget(node, 2))