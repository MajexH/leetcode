// 定义一个循环链表
function ListNode(val) {
  this.val = val
  this.next = null
}

function CircualList() {
  this.start = this.end = null
}

CircualList.prototype.insert = function (val) {
  if (this.start === null) {
    this.start = new ListNode(val)
    this.end = this.start
    this.end.next = this.start
  } else {
    this.end.next = new ListNode(val)
    this.end = this.end.next
    this.end.next = this.start
  }
}

/**
 * 给顶一个数组 和一个 index
 * 表示 每次在这个数组里面删除一个下标为index的数
 * 求每次删除的数组成的数组 按顺序
 * @param {number[]} list 
 */
function deleteNumberInCircual(list, index) {
  let circual = new CircualList()
  // 构建list
  for (let number of list) {
    circual.insert(number)
  }
  let counter = 1, res = []
  let pre = circual.end
  while (pre.next !== pre) {
    while (counter < index) {
      pre = pre.next
      counter++
    }
    res.push(pre.next.val)
    pre.next = pre.next.next
    counter = 1
  }
  res.push(pre.val)
  return res
}

console.log(deleteNumberInCircual([0,1,2,3,4,5], 3))