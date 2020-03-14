/*
 * @lc app=leetcode id=492 lang=javascript
 *
 * [492] Construct the Rectangle
 */

// @lc code=start
/**
 * @param {number} area
 * @return {number[]}
 */
var constructRectangle = function(area) {
  // 一个最合适的值肯定是从其开方开始的
  let sqrt = Math.floor(Math.sqrt(area))
  // 从开方开始寻找第一个能够满足条件的width的值 即可
  while (area % sqrt !== 0) {
    sqrt--
  }
  return [area / sqrt, sqrt]
};
// @lc code=end

