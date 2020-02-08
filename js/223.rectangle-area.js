/*
 * @lc app=leetcode id=223 lang=javascript
 *
 * [223] Rectangle Area
 */

// @lc code=start
/**
 * @param {number} A
 * @param {number} B
 * @param {number} C
 * @param {number} D
 * @param {number} E
 * @param {number} F
 * @param {number} G
 * @param {number} H
 * @return {number}
 */
var computeArea = function(A, B, C, D, E, F, G, H) { 
  let flag = true
  let left = Math.max(A, E), right = Math.min(C, G)
  if (left > right) flag = false
  let top = Math.min(D, H), bottom = Math.max(B, F)
  if (top < bottom) flag = false
  let shadow = flag ? Math.abs(left - right) * Math.abs(top - bottom) : 0
  return (C - A) * (D - B) + (G - E) * (H - F) - shadow
};
// @lc code=end

console.log(computeArea(-3,0,3,4,0,-1,9,2))
