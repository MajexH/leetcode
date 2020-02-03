/**
 * 一次可以跳一级或两级台阶
 * 上n级台阶的所有跳法
 * @param {Number} n
 */
function jumpStairs(n) {
  return recurision(n)
}

function recurision(n) {
  if (n === 0) return 1
  if (n < 0) return 0 
  return recurision(n - 1) + recurision(n - 2)
}