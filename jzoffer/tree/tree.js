function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}

function TreeNodeWithFather(val) {
  this.val = val
  this.left = this.right = this.father = null
}

module.exports = {
  TreeNode,
  TreeNodeWithFather
}