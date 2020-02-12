/*
 * @lc app=leetcode id=557 lang=javascript
 *
 * [557] Reverse Words in a String III
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
  let res = ''
  for (let i = 0; i < s.length; i++) {
    if (s.charAt(i) === ' ') {
      res += ' '
      continue
    }
    let start = i
    while (s.charAt(i) !== ' ' && i < s.length) {
      i++
    }
    res += reverseWord(s.substring(start, i))
    i--
  }
  return res
};

/**
 * 
 * @param {string} s 
 */
function reverseWord(s) {
  return s.split('').reverse().join('')
}
// @lc code=end

console.log(reverseWords("Let's take LeetCode contest"))