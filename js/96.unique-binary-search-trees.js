/*
 * @lc app=leetcode id=96 lang=javascript
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * 因为bst中数字是 1 - n 形成bst 也就是意味着 选一个点做根节点
 * 然后 左右子树再分别选一个点做根节点 这样看起来就是一个递归
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
  // dp[i] 表示 i 个节点可以形成多少个unique的bst
  let dp = Array(n + 1).fill(0)
  // 初始化 为了让乘积不出现0 因此dp[0] 也作1
  // 一个节点 只能形成一种bst
  dp[0] = 1, dp[1] = 1
  // 外层循环是由下自上 构建 dp
  for (let i = 2; i <= n; i++) {
    // 里层的循环代表了 左子树的节点数
    for (let j = 0; j < i; j++) {
      // 排列组合 选定一个节点后
      // 左子树的所有种类 组合 上右子树的 所有种类
      // 相乘 就是dp[i] 的结果
      dp[i] += dp[j] * dp[i - j - 1]
    }
  }
  return dp[n]
};
// @lc code=end

console.log(numTrees(3))