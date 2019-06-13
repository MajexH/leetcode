function ListNode(val) {
  this.val = val;
  this.next = null;
}
/**
 * @param {ListNode} origin
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList1 = function(origin) {
  if (!origin || !origin.next) return
  let head = origin
  while (head.next.next) {
    let tail = head
    while (tail.next.next) {
      tail = tail.next
    }
    tail.next.next = head.next
    head.next = tail.next
    tail.next = null
    head = head.next.next
    if (!head.next || !head)
      break
  }
  console.log(origin)
};

/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
  let cur = head, res = []
  while (cur) {
    res.push(cur)
    cur = cur.next
  }
  let flag = true, item = res.shift()
  while (res.length) {
    if (flag) {
      item.next = res.pop()
    } else {
      item.next = res.shift()
    }
    flag = !flag
    item = item.next
    if (res.length === 0) {
      item.next = null
    }
  }
};

let node = new ListNode(1)
node.next = new ListNode(2)
node.next.next = new ListNode(3)
node.next.next.next = new ListNode(4)
node.next.next.next.next = new ListNode(5)

console.log(reorderList(node))