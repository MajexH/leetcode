/*
 * @lc app=leetcode id=198 lang=javascript
 *
 * [198] House Robber
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
  if (nums.length === 0) return 0
  let dpTaken = Array(nums.length)
  let dpNotTaken = Array(nums.length)
  dpTaken[0] = nums[0]
  dpNotTaken[0] = 0
  for (let i = 1; i < nums.length; i++) {
    dpNotTaken[i] = Math.max(dpNotTaken[i - 1], dpTaken[i - 1])
    dpTaken[i] = nums[i] + dpNotTaken[i - 1]
  }
  return Math.max(dpNotTaken[nums.length - 1], dpTaken[nums.length - 1])
};
// @lc code=end

console.log(rob([2,7,9,3,1]))