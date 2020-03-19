/*
 * @lc app=leetcode id=406 lang=javascript
 *
 * [406] Queue Reconstruction by Height
 */

// @lc code=start
/**
 * @param {number[][]} people
 * @return {number[][]}
 */
var reconstructQueue = function(people) {
  // 根据身高和位置进行排序
  // 相同身高的按照升序排列
  // 整体按照身高降序排列
  // 因为 需要首先把 高身高的排好了 再去拍低身高的
  people.sort((a, b) => {
    if (b[0] === a[0])
      return a[1] - b[1]
    else
      return b[0] - a[0]
  })
  let out = []
  for (let pair of people) {
    out.splice(pair[1], 0, pair)
  }
  return out
};
// @lc code=end

console.log(reconstructQueue([[7,1], [4,4], [7,0], [5,2], [6,1], [5,0]]))