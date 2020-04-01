/*
 * @lc app=leetcode id=216 lang=javascript
 *
 * [216] Combination Sum III
 */

// @lc code=start
/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
  let res = []
  recursion(k, n, [], res, 1)
  return res
};

function recursion(k, n, temp, res, start) {
  if (temp.length === k) {
    if (temp.reduce((pre, cur) => pre + cur, 0) === n) {
      res.push([...temp])
    }
    return
  }
  for (let i = start; i <= 9; i++) {
    temp.push(i)
    recursion(k, n, temp, res, i + 1)
    temp.pop()
  }
}
// @lc code=end

console.log(combinationSum3(3, 9))