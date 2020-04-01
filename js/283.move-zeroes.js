/*
 * @lc app=leetcode id=283 lang=javascript
 *
 * [283] Move Zeroes
 */
var moveZeroes1 = function(nums) {
  let length = nums.length
  for (let i = 0; i < length;) {
    if (nums[i] === 0) {
      for (let j = i + 1; j < nums.length; j++) {
        nums[j - 1] = nums[j]
      }
      nums[nums.length - 1] = 0
      length--
      i = 0
    } else {
      i++
    }
  }
};
// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  let lastNotZero = 0
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== 0) {
      nums[lastNotZero++] = nums[i]
    }
  }
  for (let i = lastNotZero; i < nums.length; i++) {
    nums[i] = 0
  }
};
// @lc code=end

console.log(moveZeroes([0,1,0,3,12]))