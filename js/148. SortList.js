function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
  if (!head || !head.next) return head
  return mergeSort(head)
};

/**
 * 
 * @param {ListNode} head 
 */
function mergeSort(head) {
  // stop条件
  if (head.next === null) return
  // divide条件
  let divide = divideList(head)
  let a = mergeSort(head), b = mergeSort(divide)
  head = a === undefined ? head : a
  divide = b === undefined ? divide : b
  return merge(head, divide)
}

/**
 * 
 * @param {ListNode} start 
 * @param {ListNode} mid 
 */
function merge(start, mid) {
  let record = new ListNode(0), list = record
  while (start && mid) {
    if (start.val > mid.val) {
      record.next = mid
      mid = mid.next
    } else {
      record.next = start
      start = start.next
    }
    record = record.next
  }
  if (start) {
    record.next = start
  }
  if (mid) {
    record.next = mid
  }
  return list.next
}

/**
 * 
 * @param {ListNode} head 
 * @returns {ListNode}
 */
function divideList(head) {
  if (!head || !head.next) {
    return head
  }
  let first = head, last = head.next
  while (last && last.next) {
    last = last.next.next
    first = first.next
  }
  let mid = first.next
  first.next = null
  return mid
}

// let a = new ListNode(10)
// a.next = new ListNode(1)
// a.next.next = new ListNode(2)
// a.next.next.next = new ListNode(11)
let a = null

console.log(sortList(a))
