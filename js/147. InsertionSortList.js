function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertionSortList = function(head) {
  // pre 和 last 用来记录当前子列表的头和尾
  let affiliate = new ListNode(0), pre = affiliate, last = head
  affiliate.next = head;
  while (pre.next) {
    let start = pre.next
    while (start !== last) {
      if (last.next.val < start.val) {

      }
      start = start.next
    }
  }
  return affiliate.next;
};

let node = new ListNode(4)
node.next = new ListNode(2)
node.next.next = new ListNode(1)
node.next.next = new ListNode(3)
console.log(insertionSortList(node))