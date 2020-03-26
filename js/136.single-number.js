/*
 * @lc app=leetcode id=136 lang=javascript
 *
 * [136] Single Number
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
  let res = 0
  for (let num of nums) {
    res ^= num
  }
  return res
};
// @lc code=end

