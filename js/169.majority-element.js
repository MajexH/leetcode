/*
 * @lc app=leetcode id=169 lang=javascript
 *
 * [169] Majority Element
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  let start = 0, end = nums.length - 1
  let mid = Math.floor((start + end) / 2)
  let index = partition(nums, start, end)
  // 因为出现次数超过一半 因此 这个数 如果排序后 一定会出现在数组的中间位置
  while (index !== mid) {
    if (index < mid) start = index + 1
    else if (index > mid) end = index - 1
    index = partition(nums, start, end)
  }
  // 验证
  let counter = 0
  for (let i = 0; i < nums.length; i++) {
    if (nums[mid] === nums[i]) counter++
  }
  return counter >= mid ? nums[mid] : null
};

function partition(nums, start, end) {
  let base = nums[start]
  let i = start, j = end + 1
  while (true) {
    while (nums[++i] < base) if (i === end) break
    while (nums[--j] > base) if (j === start) break
    if (i >= j) break
    swap(nums, i, j)
  }
  swap(nums, start, j)
  return j
}

function swap(nums, i, j) {
  let temp = nums[i]
  nums[i] = nums[j]
  nums[j] = temp
}
// @lc code=end

console.log(majorityElement([3,2,3]))