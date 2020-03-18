/*
 * @lc app=leetcode id=55 lang=javascript
 *
 * [55] Jump Game
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
  // dp[i] 表示能否到达i这个位置
  let dp = Array(nums.length).fill(false)
  // init 0 号位置肯定是不用调就可以到达的
  dp[0] = true
  for (let i = 0; i <= nums.length; i++) {
    for (let j = 0; j < i; j++) {
      if (dp[j] === true && j + nums[j] >= i) {
        dp[i] = true
        break
      }
    }
  }
  return dp[nums.length - 1]
};
// @lc code=end

console.log(canJump([2,3,1,1,4]))
console.log(canJump([3,2,1,0,4]))