/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function(nums) {
  quickSort(nums, 0, nums.length - 1)
};

/**
 * 
 * @param {Array} array 
 * @param {number} start
 * @param {number} end
 */
function quickSort(array, start, end) {
  if (start >= end) return 
  let j = partion(array, start, end)
  quickSort(array, start, j - 1)
  quickSort(array, j + 1, end)
}

/**
 * 
 * @param {Array} array
 * @param {number} start
 * @param {number} end
 * @returns {int}
 */
function partion(array, start, end) {
  let i = start, j = end + 1
  while (true) {
    // 找到左边第一个大于他的数
    while (array[++i] < array[start]) if (i === end) break;
    // 找到右边第一个小于他的数
    while (array[--j] > array[start]) if (j === start) break;
    if (i >= j) break
    let temp = array[i]
    array[i] = array[j]
    array[j] = temp
  }
  let temp = array[start]
  array[start] = array[j]
  array[j] = temp
  return j;
}

let nums = [0, 1]
sortColors(nums)
console.log(nums)