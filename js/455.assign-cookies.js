/*
 * @lc app=leetcode id=455 lang=javascript
 *
 * [455] Assign Cookies
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
  g.sort((a, b) => a - b)
  s.sort((a, b) => a - b)
  let res = 0
  for (let i = 0, j = 0; i < g.length, j < s.length;) {
    if (g[i] <= s[j]) {
      res++
      i++
      j++
    } else {
      j++
    }
  }
  return res
};
// @lc code=end

console.log(findContentChildren([1,2], [1,2,3]))