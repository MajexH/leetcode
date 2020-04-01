/*
 * @lc app=leetcode id=22 lang=javascript
 *
 * [22] Generate Parentheses
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
  let res = []
  recursion(n, n, '', res)
  return res
};

function recursion(left, right, temp, res) {
  if (left < 0 || right < 0) return
  else if (left === 0 && right === 0) {
    res.push(temp)
  } else {
    recursion(left - 1, right, temp + '(', res)
    // 只有当已经有了 左括号 才能去遍历 右括号
    if (left < right)
      recursion(left, right - 1, temp + ')', res)
  }
}
// @lc code=end

console.log(generateParenthesis(3))