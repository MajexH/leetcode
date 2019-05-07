/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
  return recursion(nums, 0)
};

function recursion(nums, start) {
  if (start > nums.length - 1) return false
  if (start === nums.length - 1) return true
  for (let i = start; i < nums.length; i++) {
    let flag = false
    for (let j = nums[start]; j >= 1; j--) {
      if (recursion(nums, j + start)) {
        flag = true
        break
      }
    }
    return flag
  }
}