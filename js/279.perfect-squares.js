/*
 * @lc app=leetcode id=279 lang=javascript
 *
 * [279] Perfect Squares
 */

/**
 * @param {number} n
 * @return {number}
 */
var numSquaresWithRecursion = function(n) {
  let memo = Array(n + 1).fill(-1)
  if (squares.length === 0 || squares[squares.length - 1] < n) {
    for (let i = squares.length; i * i <= n; i++) {
      squares.push(i * i)
    }
  }
  return recursion(n, memo)
};

/**
 * 
 * @param {number} target 
 */
function recursion(target, memo) {
  if (target < 0) return
  if (target === 0) {
    return 0
  }
  if (memo[target] !== -1) return memo[target]
  memo[target] = Number.MAX_SAFE_INTEGER
  // 每一轮一定要选 但是 选择的 开始的数儿可以不一样
  for (let i = squares.length - 1; i >= 1; i--) {
    if (target >= squares[i])
      // 相当于现在这儿还有一个
      memo[target] = Math.min(memo[target], recursion(target - squares[i], memo) + 1)
  }
  return memo[target]
}

// @lc code=start
let squares = []
/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
  // dp[i] 表示以i作为target的时候的 最少的和
  let dp = Array(n + 1).fill(0)
  if (squares.length === 0 || squares[squares.length - 1] < n) {
    for (let i = squares.length; i * i <= n; i++) {
      squares.push(i * i)
    }
  }
  for (let i = 1; i <= n; i++) {
    dp[i] = Number.MAX_SAFE_INTEGER
    for (let j = squares.length - 1; j >= 1; j--) {
      if (i >= squares[j])
        dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1)
    }
  }
  return dp[n]
};

// @lc code=end

console.log(numSquares(12))
console.log(numSquares(55))