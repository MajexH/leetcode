/*
 * @lc app=leetcode id=409 lang=javascript
 *
 * [409] Longest Palindrome
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
  let map = new Map()
  for (let char of s) {
    if (map.has(char)) {
      map.set(char, map.get(char) + 1)
    } else {
      map.set(char, 1)
    }
  }
  let hasOdd = false, res = 0
  for (let key of map.keys()) {
    let count = map.get(key)
    if (count % 2 === 0) res += count
    else if (count > 1) {
      // 在奇数的情况下 如果大于1 可以提取中多少个一对
      // 且最后剩下个一个数儿 可以组成一个独立的个体
      res += count - 1
      hasOdd = true
    } else {
      hasOdd = true
    }
  }
  return hasOdd ? res + 1 : res
};
// @lc code=end

console.log(longestPalindrome('abccccdd'))