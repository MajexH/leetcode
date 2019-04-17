/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
  let start = 0, end = nums.length - 1
  while (start < end) {
    let mid = Math.floor((start + end) / 2)
    // 认为小于mid的部分肯定是递增的
    // 判断是否是正常的二分
    if (nums[mid] >= nums[start]) {
      // 正常的二分
      if (nums[mid] < nums[end]) {
        end = mid - 1
      }
      else {
        start = mid + 1
      }
    } else {
      end = mid
    }
  }
  return nums[start]
};


console.log(findMin([2, 1] ))