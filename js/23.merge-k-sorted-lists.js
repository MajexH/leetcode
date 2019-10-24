/*
 * @lc app=leetcode id=23 lang=javascript
 *
 * [23] Merge k Sorted Lists
 */
function ListNode(val) {
  this.val = val;
  this.next = null;
}

// @lc code=start

/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
  let head = new ListNode(0), node = head
  while (true) {
    let flag = false, array = []
    // 每次拿最小的一个
    for (let index = 0; index < lists.length; index++) {
      let list = lists[index]
      if (list !== null) {
        flag = flag || true
        array.push([list.val, index])
      } else {
        flag = flag || false
      }
    }
    array = array.sort((a, b) => {
      return a[0] - b[0]
    })
    if (array.length > 0) {
      let min = array[0][0]
      lists[array[0][1]] = lists[array[0][1]].next
      
      node.next = new ListNode(min)
      node = node.next
    }
    if (!flag) break
  }
  return head.next
};
// @lc code=end
let node = new ListNode(1)
node.next = new ListNode(4)
node.next.next = new ListNode(5)


let node1 = new ListNode(1)
node1.next = new ListNode(3)
node1.next.next = new ListNode(4)

let node2 = new ListNode(2)
node2.next = new ListNode(6)


let array = [
  node, node1, node2
]

console.log(mergeKLists(array))