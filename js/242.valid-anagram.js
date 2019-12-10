/*
 * @lc app=leetcode id=242 lang=javascript
 *
 * [242] Valid Anagram
 */

/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram1 = function(s, t) {
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

// @lc code=start
/**
 * 采用另外一种结构实现 因为两个hashmap还是相对多吃了内存
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
  // 不仅是要有相同的字母 还有相同的字母  有相同的数量
  if (s.length !== t.length) return false
  let array = Array(26).fill(0)
  for (let i = 0; i < s.length; i++) {
    array[s.charCodeAt(i) - 97]++
    array[t.charCodeAt(i) - 97]--
  }
  for (let count of array) {
    if (count !== 0) return false
  }
  return true
};
// @lc code=end

console.log(isAnagram("anagram", "nagaram"))