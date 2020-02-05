/*
 * @lc app=leetcode id=154 lang=javascript
 *
 * [154] Find Minimum in Rotated Sorted Array II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(array) {
  if (array.length === 2) { return Math.min(...array) }
  let i = 0, j = array.length - 1
  while (i < j - 1) {
    let mid = Math.floor((i + j) / 2)
    if (array[mid] === array[i] && array[mid] === array[j]) {
      // 这种情况 无法判断拐点在哪儿 因此直接顺序查找
      let min = Number.MAX_SAFE_INTEGER
      for (;i < j; i++) {
        min = Math.min(array[i], min)
      }
      return min
    } else if (array[mid] < array[i]) {
      // 异常情况 说明拐点在左边
      // 因为mid可能是最小的点
      j = mid
    } else if (array[mid] > array[j]) {
      // 异常情况
      i = mid
    } else {
      // 说明这个是一个完全的递增数列
      return array[0]
    }
  }
  return array[j]
};
// @lc code=end

