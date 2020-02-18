/*
 * @lc app=leetcode id=378 lang=javascript
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
/**
 * 因为整个二维数组 每一行每一列都是递增的 
 * 所以应用二分的思想
 * 将其从 数的范围上 进行划分
 * 因为 可以直接的找到最大的 和 最小的两个数
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(matrix, k) {
  let start = matrix[0][0], end = matrix[matrix.length - 1][matrix[0].length - 1]
  while (start <= end) {
    let mid = Math.floor((start + end) / 2)
    let count = getCount(matrix, mid)
    // 因为mid不一定是一个在矩阵中的数儿 所以不能再count === mid的时候直接返回
    if (start === end) return start
    if (count < k) {
      start = mid + 1
    } else {
      end = mid
    }
  }
  return start
};
// 找到所有小于等于mid的数
function getCount(matrix, mid) {
  let i = 0, j = 0, count = 0
  for (i = 0; i < matrix.length; i++) {
    for (j = 0; j < matrix[i].length; j++) {
      if (matrix[i][j] > mid) {
        flag = true
        break
      }
    }
    count += j
  }
  return count
}
// @lc code=end

console.log(kthSmallest([[1,2],[1,3]],4))