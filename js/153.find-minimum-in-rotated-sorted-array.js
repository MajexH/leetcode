/*
 * @lc app=leetcode id=153 lang=javascript
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  let start = 0, end = nums.length - 1
  while (start < end - 1) {
    let mid = Math.floor((start + end) / 2)
    if (nums[start] > nums[mid]) {
      end = mid
    } else if (nums[end] < nums[mid]) {
      start = mid
    } else {
    // 正常的二分
      return nums[start]
    }
  }
  return Math.min(nums[start], nums[end])
};
// @lc code=end

console.log(findMin([4,5,6,7,0,1,2]))