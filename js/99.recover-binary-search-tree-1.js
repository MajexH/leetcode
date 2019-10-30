/*
 * @lc app=leetcode id=99 lang=javascript
 *
 * [99] Recover Binary Search Tree
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start
// 保存一个数的前一个数 first second分别表示两个乱序的节点
let pre = null, first = null, second = null
/**
 * 因为二叉查找树 所以其 中序遍历 一定是一个有序的递增数组
 * 而如果交换任意两个数的顺序 一定会倒置有两个地方的顺序是乱序的
 * 因此 只需要找到两个乱序的地方 然后交换即可
 * 也就是说 当前如果 前一个数 大于 后一个数 则一定是乱序的
 * 也就只需要找到这两个数的地方 然后进行交换即可
 * 如果不存在第二个乱序的地方 则交换第一个乱序的地方的两个数即可
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
  pre = null
  first = null
  second - null
  recursion(root)
  let temp = first.val
  first.val = second.val
  second.val = temp
};

/**
 * 
 * @param {TreeNode} node 
 */
function recursion(node) {
  if (!node) return
  // 遍历左子树
  recursion(node.left)
  // 中间的部分判断是否是逆序的 然后分别记录两个逆序节点

  // 这个地方主要是在最左子树的时候 会出现
  if (!pre) pre = node
  else {
    // 如果存在逆序
    if (pre.val > node.val) {
      if (!first) first = pre
      second = node
    }
    // 在下一个地方的时候 需要更新pre
    pre = node
  }
  // 遍历右子树
  recursion(node.right)
}

// @lc code=end

let node = new TreeNode(3)
node.left = new TreeNode(1)
node.right = new TreeNode(4)
node.right.left = new TreeNode(2)
recoverTree(node)
console.log(node)