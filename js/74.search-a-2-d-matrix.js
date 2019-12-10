/*
 * @lc app=leetcode id=74 lang=javascript
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
function binarySearch(array, target) {
  let i = 0, j = array.length - 1
  while (i <= j) {
    let mid = Math.floor((i + j) / 2)
    if (array[mid] < target) i = mid + 1
    else if (array[mid] > target) j = mid - 1
    else if (array[mid] === target) return true
    else break
  }
  return false
}
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
  if (matrix.length === 0) return false
  let i = 0, j = matrix.length - 1
  while (i <= j) {
    let mid = Math.floor((i + j) / 2)
    if (matrix[mid][0] > target) j = mid - 1
    else if (matrix[mid][matrix[mid].length - 1] < target) i = mid + 1
    else return binarySearch(matrix[mid], target)
  }
  return false
};
// @lc code=end

console.log(searchMatrix([[1],[3],[5]], 5))