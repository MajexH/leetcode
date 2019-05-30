
function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 */
var BSTIterator = function(root) {
  this.node = root
};

/**
 * @return the next smallest number
 * @return {number}
 */
BSTIterator.prototype.next = function() {
  // next之后要删除最小的节点
  return this.deleteMin()
};

BSTIterator.prototype.deleteMin = function () {
  let res;
  function deleteMin(node) {
    if (!node.left) {
      res = node.val
      return node.right
    }
    node.left = deleteMin(node.left)
    return node
  }
  this.node = deleteMin(this.node)
  return res
}

/**
 * @return whether we have a next smallest number
 * @return {boolean}
 */
BSTIterator.prototype.hasNext = function() {
  return !(this.node === null)
};

/** 
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = new BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */

let root = new TreeNode(7);
root.right = new TreeNode(15);
root.right.left = new TreeNode(9);
root.right.right = new TreeNode(20);

let iterator = new BSTIterator(root);
console.log(iterator.next())
console.log(iterator.next())
console.log(iterator.hasNext())