/*
 * @lc app=leetcode id=14 lang=javascript
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
  if (strs.length === 0) return ''
  return recursion(strs, 0, strs.length - 1)
};

/**
 * 
 * @param {String} str1 
 * @param {String} str2 
 */
function getLCP(str1, str2) {
  let i = 0, j = 0
  while (i < str1.length && j < str2.length) {
    if (str1.charAt(i) === str2.charAt(j)) {
      i++;
      j++;
    } else {
      break
    }
  }
  return str1.substring(0, i)
}

/**
 * 分治法
 */
function recursion(strs, start, end) {
  if (start === end) return strs[start]
  let mid = Math.floor((start + end) / 2)
  let left = recursion(strs, start, mid)
  let right = recursion(strs, mid + 1, end)
  return getLCP(left, right)
}
// @lc code=end

console.log(longestCommonPrefix(["dog","racecar","car"]))