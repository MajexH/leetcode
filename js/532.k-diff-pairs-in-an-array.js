/*
 * @lc app=leetcode id=532 lang=javascript
 *
 * [532] K-diff Pairs in an Array
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findPairs = function(nums, k) {
  if (k < 0) return 0
  let map = new Map()
  for (let num of nums) {
    if (!map.has(num)) {
      map.set(num, 1)
    } else {
      map.set(num, map.get(num) + 1)
    }
  }
  let counter = 0
  for (let key of map.keys()) {
    if (k === 0) {
      if (map.get(key) >= 2) {
        counter++
      }
      continue
    }
    if (map.has(key - k)) {
      counter++
    }
    if (map.has(key + k)) {
      counter++
    }
    map.delete(key)
  }
  return counter
};
// @lc code=end

console.log(findPairs([1,1,1,2,2], 1))