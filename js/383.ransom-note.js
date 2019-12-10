/*
 * @lc app=leetcode id=383 lang=javascript
 *
 * [383] Ransom Note
 */

// @lc code=start



/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
  let map1 = new Map(), map2 = new Map()
  for (let item of ransomNote) {
    if (!map1.has(item)) map1.set(item, 0)
    else map1.set(item, map1.get(item) + 1)
  }
  for (let item of magazine) {
    if (!map2.has(item)) map2.set(item, 0)
    else map2.set(item, map2.get(item) + 1)
  }
  for (let key of map1.keys()) {
    if (!map2.has(key)) return false
    if (map1.get(key) > map2.get(key)) return false
  }
  return true
};
// @lc code=end
