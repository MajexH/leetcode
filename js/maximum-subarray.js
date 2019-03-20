/**
 * 全是负数的时候 有问题
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
  let max = -Infinity, curMax = 0, index = 0;
  for (let num of nums) {
    curMax += num;
    if (curMax > max) {
      max = curMax;
    }
    if (curMax < 0 && index != nums.length - 1) {
      curMax = 0;
    }
    index++;
  }
  return max
};


console.log(maxSubArray([-2, -1]))