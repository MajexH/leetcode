/*
 * @lc app=leetcode id=242 lang=javascript
 *
 * [242] Valid Anagram
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  // 不仅是要有相同的字母 还有相同的字母  有相同的数量
  if (s.length !== t.length) return false
  let mapS = new Map(), mapT = new Map()
  for (let item of s) {
    if (mapS.has(item)) {
      mapS.set(item, mapS.get(item) + 1)
    } else {
      mapS.set(item, 1)
    }
  }
  for (let item of t) {
    if (mapT.has(item)) {
      mapT.set(item, mapT.get(item) + 1)
    } else {
      mapT.set(item, 1)
    }
  }
  for (let item of mapS.keys()) {
    if (!mapT.has(item)) {
      return false
    }
    else if (mapS.get(item) !== mapT.get(item)) {
      return false
    }
  }
  return true
};
// @lc code=end

console.log(isAnagram("anagram", "nagaram"))