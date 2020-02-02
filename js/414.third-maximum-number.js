/*
 * @lc app=leetcode id=414 lang=javascript
 *
 * [414] Third Maximum Number
 */
var thirdMax1 = function(nums) {
  nums = [...new Set(nums)]
  nums.sort((a, b) => b - a)
  if (nums.length < 3) {
    return nums.shift()
  } else {
    return nums[2]
  }
};
// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function(nums) {
  let min = Number.MIN_SAFE_INTEGER, mid = Number.MIN_SAFE_INTEGER, max = Number.MIN_SAFE_INTEGER
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] === min || nums[i] === mid || nums[i] === max) continue
    if (nums[i] > max) {
      min = mid
      mid = max
      max = nums[i]
    } else if (nums[i] > mid){
      min = mid
      mid = nums[i]
    } else if (nums[i] > min){
      min = nums[i]
    }
  }
  return min === Number.MIN_SAFE_INTEGER ? max : min
};
// @lc code=end

console.log(thirdMax([5,2,2]))