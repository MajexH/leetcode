/*
 * @lc app=leetcode id=3 lang=javascript
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
  let set = new Set()
  let max = 0, i = 0, j = 0
  while (i < s.length && j < s.length) {
    // 没有重复
    if (!set.has(s.charAt(j))) {
      set.add(s.charAt(j++))
    } else {
    // 存在重复
      set.delete(s.charAt(i++))
    }
    if (set.size > max) max = set.size
  }
  return max
};
// @lc code=end

console.log(lengthOfLongestSubstring('pwwkew'))