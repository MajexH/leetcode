function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

function tranferNumberToChar(number) {
  return String.fromCharCode(number + 97)
}

/**
 * @param {TreeNode} root
 * @return {string}
 */
var smallestFromLeaf = function(root) {
  let res = null
  let stack = [], tempStack = []
  stack.push(root)
  tempStack.push(tranferNumberToChar(root.val))
  while (stack.length > 0) {
    let top = stack.pop()
    // 把数字弄进去
    let topVal = tempStack.pop()
    if (!top.left && !top.right) {
      // 叶子节点
      if (!res) {
        res = topVal
      } else {
        res = res > topVal ? topVal : res
      }
    }
    if (top.left) {
      stack.push(top.left)
      tempStack.push(tranferNumberToChar(top.left.val) + topVal)
    }
    if (top.right){
      stack.push(top.right)
      tempStack.push(tranferNumberToChar(top.right.val) + topVal)
    }
  }
  return res
};

let root = new TreeNode(25)
root.left = new TreeNode(1)
root.right = new TreeNode(3)
root.left.left = new TreeNode(1)
root.left.right = new TreeNode(3)
root.right.left = new TreeNode(0)
root.right.right = new TreeNode(2)

console.log(smallestFromLeaf(root))