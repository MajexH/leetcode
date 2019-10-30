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
/**
 * 因为递归不是一个o(1)空间的算法 因此采用morris travel
 * morris travel的思想就是在每个叶子节点的最右 将其指向下一个节点
 * 因此 采用morris travel的方式 可以在满足条件的情况下采用o(1)的空间
 * 复杂度去遍历节点
 * 因此 这样也可以找到两个逆序节点 最后再交换 即可
 * @param {TreeNode} root
 * @return {void} Do not return anything, modify root in-place instead.
 */
var recoverTree = function(root) {
  // morris遍历的思想是将叶子节点的右子树 指向下一个访问的节点
  let p = root, temp, first, second, pre
  while (p) {
    // 说明到了最左边的叶子节点
    if (!p.left) {
      // 逆序
      if (pre && pre.val > p.val) {
        if (!first) first = pre
        second = p
      }
      pre = p
      // 这个时候 这个叶子节点的右端 要么已经连上之后的节点
      // 要么继续去遍历当前节点的右子树
      p = p.right
    } else {
      // 这个时候 左子树还没遍历完
      temp = p.left
      // 如果这时候temp.right已经链接了p 其实表明它已经是一个最右端的节点
      while (temp.right && temp.right !== p)
        temp = temp.right
      if (!temp.right) {
        // 第一次访问需要讲这个节点连接到p上
        temp.right = p
        // 继续遍历
        p = p.left
      } else {
        // 逆序
        if (pre && pre.val > p.val) {
          if (!first) first = pre
          second = p
        }
        pre = p
        // 第二次访问 说明之前的左子树已经遍历完毕
        // 遍历右子树
        p = p.right
        temp.right = null
      }
    }
  }
  let temp1 = first.val
  first.val = second.val
  second.val = temp1
};

// @lc code=end

let node = new TreeNode(2)
node.left = new TreeNode(3)
node.right = new TreeNode(1)
// node.right.left = new TreeNode(2)

recoverTree(node)

console.log(node)