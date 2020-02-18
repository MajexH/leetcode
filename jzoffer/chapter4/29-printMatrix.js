/**
 * 顺时针打印一个二维矩阵
 * @param {Array[]} matrix 
 */
function printMatrix(matrix) {
  let res = ''
  // 每次遍历的一圈数字的四个角
  // 四个角由3个数字组成
  // 采用四个数字来框柱每次需要遍历的地方
  let [left, length, width] = [0, matrix[0].length - 1, matrix.length - 1]

  while (left <= width) {
    // 打印四个方向
    for (let i = left; i < length; i++) {
      res += matrix[left][i] + ','
    }
    for (let j = left; j < width; j++) {
      res += matrix[j][length] + ','
    }
    for (let i = length; i > left; i--) {
      res += matrix[width][i] + ','
    }
    for (let j = width; j > left; j--) {
      res += matrix[j][left] + ','
    }
    // 更新left length width
    if (left === length && left === width) {
      // 剩下一个点儿
      res += matrix[left][left] + ','
    }
    left++
    length--
    width--
  }
  console.log(res)
}

printMatrix([
  [ 1, 2, 3],
  [ 8, 9, 4],
  [ 7, 6, 5]
 ])