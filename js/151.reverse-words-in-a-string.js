/*
 * @lc app=leetcode id=151 lang=javascript
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
  let array = []
  for (let i = 0; i < s.length;) {
    if (s.charAt(i) === ' ') { 
      i++
      continue
    }
    else {
      let j = i
      while (s.charAt(j) !== ' ' && j < s.length) {
        j++
      }
      array.push(s.substring(i, j))
      i = j
    }
  }
  return array.reverse().join(' ')
};
// @lc code=end

console.log(reverseWords("  hello world!  "))