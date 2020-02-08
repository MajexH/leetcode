/**
 * 一次可以跳一级或两级台阶
 * 上n级台阶的所有跳法
 * @param {Number} n
 */
function jumpStairs(n) {
  let memo = Array(n + 1).fill(-1)
  memo[0] = 0
  memo[1] = 1
  recurision(n, memo)
  return memo[n]
}

function recurision(n, memo) {
  if (n <= 0) return memo[n]
  if (memo[n] !== -1) return memo[n]
  memo[n] = recurision(n - 1, memo) + recurision(n - 2, memo)
  return memo[n]
}

console.log(jumpStairs(100))