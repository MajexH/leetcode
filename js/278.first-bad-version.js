/*
 * @lc app=leetcode id=278 lang=javascript
 *
 * [278] First Bad Version
 */

// @lc code=start
/**
 * Definition for isBadVersion()
 * 
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function(isBadVersion) {
  /**
   * @param {integer} n Total versions
   * @return {integer} The first bad version
   */
  return function(n) {
    let i = 0, j = n
    while (i < j) {
      let mid = Math.floor((i + j) / 2)
      if (!isBadVersion(mid)) {
        i = mid + 1
      } else {
        j = mid
      }
    }
    return j
  };
};
// @lc code=end

