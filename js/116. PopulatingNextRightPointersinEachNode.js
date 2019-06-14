function Node(val,left,right,next) {
  this.val = val;
  this.left = left;
  this.right = right;
  this.next = next;
};

/**
 * @param {Node} root
 * @return {Node}
 */
var connect = function(root) {
  // 这道题就是层次遍历
  let queue = [], pre = null
  queue.push(root)
  queue.push(null)
  while (queue.length !== 0) {
    let item = queue.shift()
    if (!item) {
      if (queue.length === 0) break
      queue.push(null)
      pre = null
      continue
    }
    if (!pre) {
      pre = item
      console.log(1)
    }
    else {
      pre.next = item
      pre = item
      console.log(1)
    }
    if (!item.left) queue.push(item.left)
    if (!item.right) queue.push(item.right)
  }
  return root
};

let root = new Node(1, null, null, null)
root.left = new Node(2, null, null, null)
root.right = new Node(3, null, null, null)
root.left.left = new Node(4, null, null, null)
root.left.right = new Node(5, null, null, null)
root.right.left = new Node(6, null, null, null)
root.right.right = new Node(7, null, null, null)

console.log(connect(root))