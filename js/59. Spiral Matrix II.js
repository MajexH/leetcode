/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix = function(matrix) {
  let res = Array(matrix), m = 0, n = 0, direction = 0, length = matrix - 1, record = 0
  for (let i = 0; i < matrix; i++) {
    res[i] = Array(matrix) 
  }
  for (let i = 1; i <= matrix * matrix; i++) {
    // 四个方向
    switch (direction) {
      case 0:
        res[m][n++] = i
        break;
      case 1:
        res[m++][n] = i
        break;
      case 2:
        res[m][n--] = i
        break;
      case 3:
        res[m--][n] = i
        break;
    }
    // 表示一次转折
    if (direction === 3) {
      if (i - record >= length - 1) {
        direction = (direction + 1) % 4
        record = i + 1
        length -= 2
      }
    } else {
      if (i - record >= length) {
        direction = (direction + 1) % 4
        record = i
      }
    }
  }
  return res
};

console.log(generateMatrix(0))
