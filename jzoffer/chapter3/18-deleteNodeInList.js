function ListNode(val) {
  this.val = val
  this.next = null
}

/**
 * 在o(1)的时间内删除toBeDeleted节点
 * 因为要在o(1)的时间内删除 所以从start节点开始寻找的方式是o(n) 不满足
 * 因此直接将toBeleted 后面的节点 向前移动一位 再把后一个节点删除即可
 * @param {ListNode} start 
 * @param {ListNode} toBeDeleted 
 */
function deleteNode(start, toBeDeleted) {
  if (toBeDeleted.next) {
    let after = toBeDeleted.next
    toBeDeleted.val = after.val
    toBeDeleted.next = after.next
  } else if (start === toBeDeleted) {
    start = null
  } else {
  // 如果要删除的是尾节点 只能从头开始遍历 找到前序节点
    let temp = start
    while (temp.next.next !== null) {
      temp = temp.next
    }
    temp.next = null
  }
}

let node = new ListNode(1)
let node1 = new ListNode(2)
let node2 = new ListNode(3)
node.next = node1
node1.next = node2

deleteNode(node, node2)

console.log(node)