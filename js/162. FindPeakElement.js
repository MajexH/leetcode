/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement1 = function(nums) {
  if (nums.length === 1) return 0
  for (let i = 0; i < nums.length; i++) {
    if (i === 0 && nums[i] > nums[i + 1]) {
      return i
    } 
    if (i === nums.length - 1 && nums[i] > nums[i - 1]) {
      return i
    }
    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
      return i
  }
};

/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
  let left = 0, right = nums.length - 1
  while (left < right) {
    let mid = Math.floor((left + right) / 2)
    if (nums[mid] > nums[mid + 1]) {
      right = mid
    } else {
      left = mid + 1
    }
  }
  return right
};


console.log(findPeakElement([1]))