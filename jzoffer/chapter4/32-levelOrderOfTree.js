function TreeNode(val) {
  this.val = val
  this.left = this.right = null
}
/**
 * 
 * @param {TreeNode} root 
 */
function levelOrder(root) {
  let res = ''
  let queue = []
  queue.push(root)
  queue.push(null)
  while (queue.length !== 0) {
    let head = queue.shift()
    // 说明现在上一层已经遍历完了
    if (head === null) {
      // 已经遍历完所有的节点
      if (queue.length === 0) break
      // 上一层需要加入的下一层的所有节点已经加入 因此需要直接加一个标识
      // 告诉这一层也完了
      queue.push(null)
      res += '\n'
      continue
    }

    if (head.left) {
      queue.push(head.left)
    }
    if (head.right) {
      queue.push(head.right)
    }
    res += head.val + ','
  }
  return res
}

let root = new TreeNode(8)
root.left = new TreeNode(6)
root.right = new TreeNode(10)

root.left.left = new TreeNode(5)
root.left.right = new TreeNode(7)
root.right.left = new TreeNode(9)
root.right.right = new TreeNode(11)

console.log(levelOrder(root))
console.log(zigZagLevelOrder(root))
/**
 * 按照之字形来打印
 * @param {TreeNode} root 
 */
function zigZagLevelOrder(root) {
  let queue = [], res = '', temp = ''
  // true 代表方向向右 false代表遍历方向向左
  let direction = true
  queue.push(root)
  queue.push(null)
  while (queue.length !== 0) {
    let head = queue.shift()
    if (!head) {
      let array = temp.split(',')
      array.pop()
      if (direction) {
        res += array.join(' ') + ' '
      } else {
        res += array.reverse().join(' ') + ' '
      }
      temp = ''
      if (queue.length === 0) break
      queue.push(null)
      // 更改方向
      direction = !direction
      continue
    }
    if (head.left) {
      queue.push(head.left)
    }
    if (head.right) {
      queue.push(head.right)
    }
    temp += head.val + ','
  }
  return res
}