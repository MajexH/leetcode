/*
 * @lc app=leetcode id=128 lang=javascript
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {
  let set = new Set(nums)
  let res = 0
  for (let num of nums) {
    let length = 1
    let tempFind = num + 1
    while (set.has(tempFind)) {
      set.delete(tempFind)
      length++
      tempFind++
    }
    tempFind = num - 1
    while (set.has(tempFind)) {
      set.delete(tempFind)
      length++
      tempFind--
    }
    res = Math.max(res, length)
  }
  return res
};
// @lc code=end

console.log(longestConsecutive([100, 4, 200, 1, 3, 2]))