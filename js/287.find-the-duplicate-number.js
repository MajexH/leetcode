/*
 * @lc app=leetcode id=287 lang=javascript
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findDuplicate = function(nums) {
  let i = 1, j = nums.length
  while (i < j) {
    let mid = Math.floor((i + j) / 2)
    let count = getCount(nums, i, mid)
    if (count > mid - i + 1) {
      j = mid
    } else {
      i = mid + 1
    }
  }
  return i
};

/**
 * 
 * @param {number[]} nums 
 * @param {number} start 
 * @param {number} end
 * @returns {number} 计算start end中间有多少个数 
 */
function getCount(nums, start, end) {
  let res = 0
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] <= end && nums[i] >= start)
      res++
  }
  return res
}
// @lc code=end

console.log(findDuplicate([1,4,4,2,4]))