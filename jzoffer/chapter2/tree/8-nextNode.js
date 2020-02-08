const { TreeNodeWithFather : TreeNode } = require('./tree.js');

/**
 * 给定一个current 找到current在前序遍历中的下一个节点
 * @param {TreeNode} current
 * @returns {TreeNode}
 */
function getNextNode(current) {
  // 下一个节点 一定在右子树的最左子树
  // 如果没有右子树 
  // 如果当前节点是其父节点的左子树 则下一个一定是父节点
  // 如果是右子树 需要找到一个父节点是其左子节点的节点
  // 其实就是找到这么一个地方 找到一个左子树遍历完毕的点 这样其父节点就一定是其下一个节点
  if (current.right) {
    let temp = current.right
    while (temp.left) {
      temp = temp.left
    }
    return temp
  } else if (current.father.left === current) {
    return current.father
  } else if (current.father.right === current) {
    let temp = current.father
    while (temp.left !== current && temp.father !== null) {
      temp = temp.father
      current = current.father
    }
    if (temp.left !== current) return null
    return temp
  }
  return null
}

let root = new TreeNode('a')
let left = new TreeNode('b')
let right = new TreeNode('c')

root.left = left
root.right = right
left.father = root
right.father = root

let leftLeft = new TreeNode('d')
let leftRight = new TreeNode('e')

left.left = leftLeft
left.right = leftRight

leftLeft.father = left
leftRight.father = left

let rightLeft = new TreeNode('f')
let rightRight = new TreeNode('g')

right.left = rightLeft
right.right = rightRight

rightRight.father = right
rightLeft.father = right

let leftRightLeft = new TreeNode('h')
let leftRightRight = new TreeNode('i')

leftRight.left = leftRightLeft
leftRight.right = leftRightRight

leftRightLeft.father = leftRight
leftRightRight.father = leftRight

console.log(getNextNode(rightRight))