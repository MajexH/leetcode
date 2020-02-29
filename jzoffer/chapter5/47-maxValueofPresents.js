/**
 * 给定一个二维的矩阵
 * 从左上角出发 一直到右下角
 * 每次只能向右或者向下
 * 求带大的从左上到右下的值
 * @param {number[][]} matrix 
 */
function maxValue(matrix) {
  let dp = Array(matrix.length)
  for (let i = 0; i < matrix.length; i++) {
    dp[i] = Array(matrix[i].length)
  }
  for (let i = 0; i < matrix.length; i++) {
    for (let j = 0; j < matrix[i].length; j++) {
      let temp = Math.max(i - 1 < 0 ? Number.MIN_SAFE_INTEGER : dp[i - 1][j], j - 1 < 0 ? Number.MIN_SAFE_INTEGER : dp[i][j - 1])
      temp = temp === Number.MIN_SAFE_INTEGER ? 0 : temp
      dp[i][j] = temp + matrix[i][j]
    }
  }
  return dp[matrix.length - 1][matrix[matrix.length - 1].length - 1]
}

console.log(maxValue([
  [1,10,3,8],
  [12,2,9,6],
  [5,7,4,11],
  [3,7,16,5]
]))