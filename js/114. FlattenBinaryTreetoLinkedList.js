function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * 其实就是利用DST
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var flatten = function(root) {
  if (!root) return
  flatten(root.left)
  flatten(root.right)
  let cur = root.left
  if (!cur) {
    return
  }
  while (cur.right) {
    cur = cur.right
  }
  cur.right = root.right
  root.right = root.left
  root.left = null
  return
};

let root = new TreeNode(1)
root.left = new TreeNode(2)
root.left.left = new TreeNode(3)
root.left.right = new TreeNode(4)
root.right = new TreeNode(5)
root.right.right = new TreeNode(6)

flatten(root)
console.log(root)