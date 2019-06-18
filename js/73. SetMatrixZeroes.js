/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
  let m = matrix.length, n = matrix[0].length
  let point = []
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (matrix[i][j] === 0)
        point.push({
          x: i,
          y: j
        })
    }
  }
  let x = [], y = []
  for (let item of point) {
    if (!x.find((val) => val === item.x)) {
    // 没找到表示这一行还没变成0
      for (let temp = 0; temp < n; temp++) {
        matrix[item.x][temp] =0
      }
      x.push(item.x)
    }
    if (!y.find((val) => val === item.y)) {
    // 没找到表示这一列还没变成0
      for (let temp = 0; temp < m; temp++) {
        matrix[temp][item.y] =0
      }
      y.push(item.y)
    }
  }
};
