/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
  let n = nums.length, i = 0
  while (i < n) {
    if (nums[i] === 0) {
      // 移动
      let j;
      for (j = i; j < n - 1; j++) {
        nums[j] = nums[j + 1]
      }
      nums[j] = 0
      n--
      i = 0
    } else {
      i++
    }
  }
  console.log(nums)
};

console.log(moveZeroes([0,0,1]))