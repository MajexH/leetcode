/*
 * @lc app=leetcode id=274 lang=javascript
 *
 * [274] H-Index
 */

// @lc code=start
/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {
  citations.sort((a, b) => a - b)
  let res = 0
  for (let i = 0; i < citations.length; i++) {
    if (citations[i] >= citations.length - i && citations.length - i > res) {
      res = citations.length - i
    }
  }
  return res
};
// @lc code=end

console.log(hIndex([3,0,6,1,5]))