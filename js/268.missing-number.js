/*
 * @lc app=leetcode id=268 lang=javascript
 *
 * [268] Missing Number
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var missingNumber = function(nums) {
  let n = nums.length
  let sum = nums.reduce((pre, cur) => pre + cur, 0)
  return ((1 + n) * n) / 2 - sum
};

// @lc code=end

console.log(missingNumber([3,0,1]))