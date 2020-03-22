/*
 * @lc app=leetcode id=581 lang=javascript
 *
 * [581] Shortest Unsorted Continuous Subarray
 */
let min = Number.MAX_SAFE_INTEGER
let max = Number.MIN_SAFE_INTEGER
/**
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray1 = function(nums) {
  min = Number.MAX_SAFE_INTEGER
  max = Number.MIN_SAFE_INTEGER
  mergeSort(nums, 0, nums.length - 1)
  return min === Number.MAX_SAFE_INTEGER ? 0 : max - min + 1
};

function mergeSort(array, start, end) {
  if (start >= end) return
  let mid = Math.floor((start + end) / 2)
  mergeSort(array, start, mid)
  mergeSort(array, mid + 1, end)
  merge(array, start, mid, end)
}

function merge(array, start, mid, end) {
  let i = start, j = mid + 1, temp = []
  while (i <= mid && j <= end) {
    if (array[i] <= array[j]) {
      temp.push(array[i++])
    } else {
      // 失序地方
      min = Math.min(i, min)
      max = Math.max(j, max)
      temp.push(array[j++])
    }
  }
  while (i <= mid) temp.push(array[i++])
  while (j <= end) temp.push(array[j++])
  for (let indexT = 0, indexA = start; indexA <= end; indexA++, indexT++) {
    array[indexA] = temp[indexT]
  }
}
// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function(nums) {
  let max = Number.MIN_SAFE_INTEGER, min = Number.MAX_SAFE_INTEGER, left = -1, right = -2;
  for (let i = 0; i < nums.length; i ++) {
    // 分别从两个方面找到 right index 和 left index
    // max 表示 从左到右的 最大值
    // min 表示 从右到左的 最小值
    max = Math.max(nums[i], max)
    min = Math.min(nums[nums.length - 1 - i], min)
    // 如果 从左到右 这时候 找到一个比 max小的值 说明 这时候 这个地方逆序了
    // 如果 从右到左 这时候找到一个比前面找到的最小值 还大的 说明 这个地方也逆序了
    // 迭代 分别找到 最左和最右 的值
    if (nums[i] < max) right = i
    if (nums[nums.length - 1 - i] > min) left = nums.length - 1 - i
  }
  return right - left + 1
};
// @lc code=end

console.log(findUnsortedSubarray([1,2,3,3,3]))