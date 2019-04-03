function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {boolean}
 */
var isSameTree = function(p, q) {
  if (p === null && q === null)
    return true
  if (p === null || q === null)
    return false
  if (p.val !== q.val)
    return false
  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
};

let p = new TreeNode(1)
p.left = new TreeNode(2)
p.right = new TreeNode(3)

let q = new TreeNode(1)
q.left = new TreeNode(2)
q.right = new TreeNode(3)
console.log(isSameTree(p, q))