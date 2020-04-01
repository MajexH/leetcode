/*
 * @lc app=leetcode id=290 lang=javascript
 *
 * [290] Word Pattern
 */

// @lc code=start
/**
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 */
var wordPattern = function(pattern, str) {
  let strArray = str.split(' ')
  if (pattern.length !== strArray.length) return false
  let map = new Map(), set = new Set()
  // map 用来保存 pattern 字母的上次出现的位置
  for (let i = 0; i < pattern.length; i++) {
    set.add(strArray[i])
    if (!map.has(pattern.charAt(i))) {
      map.set(pattern.charAt(i), i)
    } else {
      if (strArray[i] !== strArray[map.get(pattern.charAt(i))])
        return false
    }
  }
  // 最后如果其绝对数量不相同的话 意味着 之间存在重复 因此不对
  return set.size === map.size ? true : false
};
// @lc code=end

console.log(wordPattern("abba", "dog dog dog dog"))