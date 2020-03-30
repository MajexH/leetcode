/*
 * @lc app=leetcode id=209 lang=javascript
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
/**
 * @param {number} s
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function(s, nums) {
  let left = 0, sum = 0, res = Number.MAX_SAFE_INTEGER
  for (let i = 0; i < nums.length; i++) {
    sum += nums[i]
    while (sum >= s) {
      res = Math.min(res, i - left + 1)
      sum -= nums[left++]
    }
  }
  return res === Number.MAX_SAFE_INTEGER ? 0 : res
};
// @lc code=end

