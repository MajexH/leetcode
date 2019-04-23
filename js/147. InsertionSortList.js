function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var insertionSortList = function(head) {
  let affiliate = new ListNode(0), pre = affiliate, last = head
  affiliate.next = head;
  while (true) {
    if (!last) break
    let item = pre.next, insert = last.next
    if (!insert) break
    while (item !== insert) {
      // 如果item的值大于insert 意味着insert要插入到item前面
      // 此时 如果插入了 则可以知道last肯定向后移动一位
      if (item.val > insert.val) {
        // 首先将insert拿出来
        last.next = last.next.next;
        // 讲insert插入item前面
        pre.next = insert;
        insert.next = item;
        break;
      }
      item = item.next
      pre = pre.next
    }
    // 如果没插入 需要将last后移一位
    if (item === insert) {
      last = last.next
    }
    // 重置pre指针
    pre = affiliate
  }
  return affiliate.next;
};

let node = new ListNode(-1)
node.next = new ListNode(5)
node.next.next = new ListNode(3)
node.next.next.next = new ListNode(4)
node.next.next.next.next = new ListNode(0)
console.log(insertionSortList(node))