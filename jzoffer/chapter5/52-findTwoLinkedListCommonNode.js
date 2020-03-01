function ListNode(val) {
  this.val = val
  this.next = null
}

/**
 * 找到两个list中的第一个公共节点
 * 因为这是从前向后list 而公共节点在两个list中间 
 * 因为从前向后 可能在公共节点前两个list的长度不等
 * 但是从后往前 公共节点的长度是一样的
 * 因此用 stack 保存两个的遍历路径 再同时弹栈即可
 * @param {ListNode} list1 
 * @param {ListNode} list2 
 * @returns {ListNode}
 */
function findCommonNodeInList(list1, list2) {
  let array1 = [], array2 = []

  while (list1) {
    array1.push(list1)
    list1 = list1.next
  }
  while (list2) {
    array2.push(list2)
    list2 = list2.next
  }

  let res = null
  while (array1.length !== 0 && array2.length !== 0 && (array1[array1.length - 1].val === array2[array2.length - 1].val)) {
    res = array1.pop()
    array2.pop()
  }
  return res
}

let common = new ListNode(6)
common.next = new ListNode(7)

let list1 = new ListNode(1)
list1.next = new ListNode(2)
list1.next.next = new ListNode(3)
list1.next.next.next = common

let list2 = new ListNode(4)
list2.next = common

console.log(findCommonNodeInList(list1, list2))