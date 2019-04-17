/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum1 = function(numbers, target) {
  for (let i = 0; i < numbers.length; i++) {
    // 因为是排序过的 所以 从i开始  因为i-1已经尝试过了
    let index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i])
    if (index !== -1)
      return [i + 1, index + 1]
  }
};

/**
 * 
 * @param {Array} nums 
 * @param {number} start 数组查找的开始位置
 * @param {number} end 数组的结束位置
 * @return {number} 当前第二的索引位置
 */
function binarySearch(nums, start, end, target) {
  while (start <= end) {
    let mid = Math.floor((start + end) / 2)
    if (nums[mid] === target) {
      return mid
    } else if (nums[mid] > target) {
      end = mid - 1
    } else {
      start = mid + 1
    }
  }
  return -1;
}


/**
 * @param {number[]} numbers
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(numbers, target) {
  for (let i = 0, j = numbers.length - 1; i <= j;) {
    let sum = numbers[i] + numbers[j]
    if (sum < target) {
      i++;
    } else if (sum > target) {
      j--;
    } else {
      return [i + 1, j + 1]
    }
  }
};

console.log(twoSum([2,7,11,15], 9))