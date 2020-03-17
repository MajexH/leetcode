/*
 * @lc app=leetcode id=324 lang=javascript
 *
 * [324] Wiggle Sort II
 */

// @lc code=start
/**
 * 其实整体的思想就是找到中间的数儿
 * 根据中间的数儿 分成两段 
 * 分别从两段中取出一个数 连接起来
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var wiggleSort = function(nums) {
  let mid = Math.floor((nums.length - 1) / 2)
  let start = 0, end = nums.length - 1
  let index = partition(nums, start, end)
  while (index !== mid) {
    if (index > mid) {
      end = index - 1
    } else if (index < mid) {
      start = index + 1
    }
    index = partition(nums, start, end)
  }
  // 通过以上的步骤 可以将 大小分开 前面一半的数组是小的 后面一半的数组是大的
  let temp = Array(nums.length), odd = 1, even = nums.length % 2 === 0 ? nums.length - 2 : nums.length - 1;
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] > nums[mid]) {
      temp[odd] = nums[i]
      odd += 2
    } else if (nums[i] < nums[mid]) {
      temp[even] = nums[i]
      even -= 2
    }
  }
  while (odd < nums.length) {
    temp[odd] = nums[mid]
    odd += 2
  }
  while (even >= 0) {
    temp[even] = nums[mid]
    even -= 2
  }
  for (let i = 0; i < nums.length; i++) {
    nums[i] = temp[i]
  }
}

function partition(array, start, end) {
  let base = array[start]
  let i = start, j = end + 1
  while (i < j) {
    while (array[++i] < base) if (i === end) break
    while (array[--j] > base) if (j === start) break
    if (i >= j) break
    let temp = array[i]
    array[i] = array[j]
    array[j] = temp
  }
  array[start] = array[j]
  array[j] = base
  return j
}
// @lc code=end
let a = [4,5,5,6]
wiggleSort(a)
console.log(a)