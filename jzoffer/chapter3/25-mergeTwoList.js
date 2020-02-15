function ListNode(val) {
  this.val = val
  this.next = null
}
/**
 * 合并两个已经排好序的list为一个list 并返回
 * @param {ListNode} list1 
 * @param {ListNode} list2 
 * @returns {ListNode}
 */
function mergeTwoSortedList(list1, list2) {
  if (list1 === null) return list2
  else if (list2 === null) return list1

  let res = new ListNode(0), temp = res
  while (list1 !== null && list2 !== null) {
    if (list1.val < list2.val) {
      temp.next = new ListNode(list1.val)
      temp = temp.next
      list1 = list1.next
    } else {
      temp.next = new ListNode(list2.val)
      temp = temp.next
      list2 = list2.next
    }
  }
  if (list1) temp.next = list1
  if (list2) temp.next = list2
  return res.next
}

let head = new ListNode(1)
head.next = new ListNode(3)
head.next.next = new ListNode(5)
head.next.next.next = new ListNode(7)

let head1 = new ListNode(2)
head1.next = new ListNode(4)
head1.next.next = new ListNode(6)
head1.next.next.next = new ListNode(7)

console.log(mergeTwoSortedList(head, head1))