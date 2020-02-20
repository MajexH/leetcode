/**
 * 复杂链表的赋值
 * @param {Object} val 
 */
function ListNode(val) {
  this.val = val
  this.next = null
  this.slibling = null
}
/**
 * 深拷贝一个List 并返回深拷贝的对象
 * @param {ListNode} list 
 * @returns {ListNode}
 */
function copyLinkedList(list) {
  let listCopy = new ListNode(0), headCopy = listCopy, recordList = list
  let map = new Map()
  // 第一个想法是扫描两遍 
  // 第一遍创建节点
  while (list) {
    if (!map.has(list.val)) {
      map.set(list.val, new ListNode(list.val))
    }
    list = list.next
  }
  // 第二遍创建联系
  while (recordList) {
    // next
    headCopy.next = map.get(recordList.val)
    // slibling
    if (recordList.slibling) {
      headCopy.next.slibling = map.get(recordList.slibling.val)
    }

    headCopy = headCopy.next
    recordList = recordList.next
  }

  return listCopy.next
}

/**
 * 上面那种方法 实际上是以o(n)的空间去换取o(n)的时间
 * 为了不适用辅助空间 采用一个思想
 * 扫描3遍
 * 第一遍扫描复制节点 将复制的节点放到当前节点的后面
 * 第二遍扫描 复制节点的slibling信息
 * 第三遍重建节点
 * @param {ListNode} list 
 */
function copyListExample(list) {
  // 第一遍 copy节点
  copyNode(list)

  // 第二遍 link slibling
  linkSlibling(list)
  // 第三遍 分离
  return generateCopy(list)
}

/**
 * copy一个节点 放到list后面
 * @param {ListNode} list 
 */
function copyNode(list) {
  while (list) {
    let node = new ListNode(list.val)
    node.next = list.next
    list.next = node
    list = list.next.next
  }
}

function linkSlibling(list) {
  while (list) {
    if (list.slibling)
      list.next.slibling = list.slibling.next
    list = list.next.next
  }
}

function generateCopy(list) {
  let res = new ListNode(1), temp = res
  while (list) {
    // res
    res.next = list.next
    res = res.next
    // 去除
    list.next = list.next.next
    list = list.next
  }
  return temp.next
}

let node = new ListNode('a')
let node1 = new ListNode('b')
let node2 = new ListNode('c')
let node3 = new ListNode('d')
let node4 = new ListNode('e')

node.next = node1
node.slibling = node2

node1.next = node2
node1.slibling = node4

node2.next = node3
node2.slibling = node2

node3.next = node4
node3.slibling = node1

console.log(copyLinkedList(node))
console.log(copyListExample(node))