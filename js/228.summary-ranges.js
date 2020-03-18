/*
 * @lc app=leetcode id=228 lang=javascript
 *
 * [228] Summary Ranges
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
  let start = null, res = [];
  for (let i = 0; i < nums.length; i++) {
    if (start === null) {
      start = i
    }
    if (i === nums.length - 1 || nums[i + 1] - nums[i] !== 1) {
      // 不连续
      if (start === i) res.push(`${nums[start]}`)
      else res.push(`${nums[start]}->${nums[i]}`)
      start = null
    }
  }
  return res
};
// @lc code=end

console.log(summaryRanges([0,1,2,4,5,7]))
console.log(summaryRanges([0,2,3,4,6,8,9]))