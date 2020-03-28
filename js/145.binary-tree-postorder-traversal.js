/*
 * @lc app=leetcode id=145 lang=javascript
 *
 * [145] Binary Tree Postorder Traversal
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

// @lc code=start

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root) {
  let stack = [], res = []
  while (root || stack.length !== 0) {
    while (root) {
      // flag 表示是否是第二次弹出 因为
      // 后序遍历的时候 父节点要最后访问
      // 因此 父节点会被 访问两次
      root.flag = false
      stack.push(root)
      root = root.left
    }
    if (stack.length !== 0) {
      root = stack.pop()
      // 第二次弹出 则其 左右 子节点均访问完毕
      if (root.flag) {
        res.push(root.val)
        // 必须置位null 因为 表示这个节点已经访问完了 要去访问stack中之前保存的节点
        root = null
      } else {
        // 第一次弹出
        root.flag = true
        stack.push(root)
        root = root.right
      }
    }
  }
  return res
};
// @lc code=end

