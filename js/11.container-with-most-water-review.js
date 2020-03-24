/*
 * @lc app=leetcode id=11 lang=javascript
 *
 * [11] Container With Most Water
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
  let max = 0, left = 0, right = height.length - 1
  while (left < right) {
    max = Math.max(max, Math.min(height[left], height[right]) * (right - left))
    // 往高度小的方向移动 为什么呢
    // 因为相较于 之前的状态 如果之前的小的height 变大了 则如果抵消了 长度缩短额话
    // 有可能面积会变大
    if (height[left] < height[right]) left++
    else right--
  }
  return max
};
// @lc code=end

