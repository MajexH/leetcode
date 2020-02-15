function ListNode(val) {
  this.val = val
  this.next = null
}
/**
 * 找到head的list中的环的入口元素
 * 入口元素 就是第一个被重复访问到的节点
 * @param {ListNode} head 
 * @returns {ListNode}
 */
function findLoopInList(head) {
  let set = new Set()
  while (head) {
    if (set.has(head)) {
      return head
    } else {
      set.add(head)
    }
    head = head.next
  }
  // 遍历完了 没有
  return null
}

/**
 * 找到list中的环的入口元素
 * 书上的解法
 * 首先是 找到环 再根据找到的环 找到环中的数量
 * 再根据 环中的 数量 找到 起始节点
 * @param {ListNode} head
 */
function findLoopInListExample(head) {
  // 第一遍 先确定是否存在环
  let fast = head.next, last = head
  // 这种情况不可能有环
  if (last === null || fast === null)
    return null
  while (fast !== last) {
    // 这种情况也是不存在环的
    if (fast.next === null)
      return null
    fast = fast.next.next
    last = last.next
  }
  // 第二遍循环 确定环的大小
  // 这时fast和last都指向同一个节点
  let counter = 1
  fast = fast.next
  while (fast !== last) {
    fast = fast.next
    counter++
  }
  // 第三遍循环 寻找 开始的节点
  fast = head
  last = head
  for (let i = 0; i < counter; i++) {
    fast = fast.next
  }
  while (fast !== last) {
    fast = fast.next
    last = last.next
  }
  return fast
}

let head = new ListNode(1)
head.next = new ListNode(2)
let node3 = new ListNode(3)
head.next.next = node3
head.next.next.next = new ListNode(4)
head.next.next.next.next = new ListNode(5)
head.next.next.next.next.next = new ListNode(6)
head.next.next.next.next.next.next = node3

console.log(findLoopInListExample(head))