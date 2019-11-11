/*
 * @lc app=leetcode id=187 lang=javascript
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var findRepeatedDnaSequences = function(s) {
  let set = new Set(), res = new Set()
  for (let i = 0; i + 9 < s.length; i++) {
    let sub = s.substring(i, i + 10)
    if (set.has(sub)) {
      res.add(sub)
    } else {
      set.add(sub)
    }
  }
  return [...res]
};
// @lc code=end

console.log(findRepeatedDnaSequences("AAAAAAAAAAAA"))