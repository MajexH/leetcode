/*
 * @lc app=leetcode id=540 lang=javascript
 *
 * [540] Single Element in a Sorted Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
  let i = 0, j = nums.length - 1
  while (i < j) {
    let mid = Math.floor((i + j) / 2)
    // 如果这个时候mid是一个偶数的下标 说明到这个mid为止 前面有奇数个数儿
    // 而前一个数儿跟他相等
    // 则说明剩下的一个数的 在左边
    if (mid % 2 === 0) {
      if (nums[mid] === nums[mid - 1]) {
        j = mid - 2
      } else if (nums[mid] === nums[mid + 1]){
        i = mid + 2
      } else {
        return nums[mid]
      }
    } else {
      if (nums[mid] === nums[mid - 1]) {
      // 如果这个时候mid是一个奇数的下标 说明到这个mid为止 前面有偶数个数儿
        i = mid + 1
      } else if (nums[mid] === nums[mid + 1]){
        j = mid - 1
      } else {
        return nums[mid]
      }
    }
  }
  return nums[j]
};
// @lc code=end

console.log(singleNonDuplicate([1,1,2,3,3]))