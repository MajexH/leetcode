/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
  // 矩阵是几乘几的
  let n = matrix.length;
  for (let i = n; i > 1; i -= 2) {
    // 开始交换的index
    let start = (n - i) / 2;
    // 结束的index
    let end = start + i - 1;
    // 交换四个角的数值
    for (let j = 0; j < i - 1; j++) {
      let temp = matrix[start][start + j];
      matrix[start][start + j] = matrix[end - j][start];
      matrix[end - j][start] = matrix[end][end - j];
      matrix[end][end - j] = matrix[start + j][end];
      matrix[start + j][end] = temp;
    }
  }
};

let matrix = [[1,2,3], [4,5,6], [7,8,9]]
rotate(matrix)
console.log(matrix)