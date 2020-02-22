/*
 * @lc app=leetcode id=485 lang=javascript
 *
 * [485] Max Consecutive Ones
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxConsecutiveOnes = function(nums) {
  let memo = Array(nums.length + 1).fill(0)
  let max = Number.MIN_SAFE_INTEGER
  for (let i = 1; i <= nums.length; i++) {
    if (nums[i - 1] === 1) {
      if (i === 1 || nums[i - 2] === 1) {
        memo[i] = memo[i - 1] + 1
      } else {
        memo[i] = 1
      }
    }
    max = Math.max(memo[i], max)
  }
  return max
};
// @lc code=end

console.log(findMaxConsecutiveOnes([1,1,0,1,1,1]))