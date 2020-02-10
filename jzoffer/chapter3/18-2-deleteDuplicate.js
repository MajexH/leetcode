function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * 删除一个list中的重复的数字节点 删除之后 重复的节点 保留一个
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicatesLeaveOne = function(head) {
  let pre = head, later = head
  while (later) {
    while (later.next && later.next.val === later.val) {
      later = later.next
    }
    pre.next = later.next
    pre = pre.next
    later = pre
  }
};

/**
 * 删除一个list中的重复的数字节点 不保留重复的节点
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {
  let pre = new ListNode(0), later = head
  pre.next = head
  let record = pre
  while (later) {
    while (later.next && later.next.val === later.val) {
      later = later.next
    }
    // 说明后一个数也是只有一个的
    if (pre.next === later) {
      pre = later
      later = later.next
    } else {
      later = later.next
      // 已经抵达末尾
      if (!later) {
        pre.next = later
        continue
      }
      if (later.next && later.next.val === later.val) continue
      pre.next = later
      pre = pre.next
      later = later.next
    }
  }
  return record.next
};

let node = new ListNode(1)
node.next = new ListNode(1)
node.next.next = new ListNode(2)
node.next.next.next = new ListNode(3)
node.next.next.next.next = new ListNode(3)

console.log(deleteDuplicates(node))