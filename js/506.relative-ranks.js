/*
 * @lc app=leetcode id=506 lang=javascript
 *
 * [506] Relative Ranks
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {string[]}
 */
var findRelativeRanks = function(nums) {
  let temp = new Map(),res = Array(nums.length)
  for (let i = 0; i < nums.length; i++) {
    temp.set(nums[i], i)
  }
  mergeSort(nums, 0, nums.length - 1)
  for (let i = 0; i < nums.length; i++) {
    let index = temp.get(nums[i])
    if (i === 0) res[index] = 'Gold Medal'
    else if (i === 1) res[index] = 'Silver Medal'
    else if (i === 2) res[index] = 'Bronze Medal'
    else res[index] = `${i + 1}`
  }
  return res
};

function mergeSort(nums, start, end) {
  if (start >= end) return
  let mid = Math.floor((start + end) / 2)
  mergeSort(nums, start, mid)
  mergeSort(nums, mid + 1, end)
  merge(nums, start, mid, end)
}

function merge(nums, start, mid, end) {
  let i = start, j = mid + 1
  let temp = []
  while (i <= mid && j <= end) {
    if (nums[i] > nums[j]) {
      temp.push(nums[i++])
    } else {
      temp.push(nums[j++])
    }
  }
  while (i <= mid) temp.push(nums[i++])
  while (j <= end) temp.push(nums[j++])
  for (let indexT = 0, indexN = start; indexT < temp.length; indexT++, indexN++) {
    nums[indexN] = temp[indexT]
  }
}
// @lc code=end

console.log(findRelativeRanks([5, 4, 3, 2, 1]))