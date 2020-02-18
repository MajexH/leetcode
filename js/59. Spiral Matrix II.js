/**
 * @param {number} n
 * @return {number[][]}
 */
var generateMatrix1 = function(matrix) {
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

var generateMatrix = function(matrix) {
  // 用三个数字 确定四个角
  let [left, length, width] = [0, matrix - 1, matrix - 1]
  let counter = 1, res = Array(matrix)
  for (let i = 0; i < matrix; i++) {
    res[i] = Array(matrix) 
  }
  while (left <= width) {
    // 四个方向
    for (let i = left; i < length; i++) {
      res[left][i] = counter++
    }
    for (let j = left; j < width; j++) {
      res[j][length] = counter++
    }
    for (let i = length; i > left; i--) {
      res[width][i] = counter++
    }
    for (let j = width; j > left; j--) {
      res[j][left] = counter++
    }
    if (left === length && left === width) {
      // 剩下一个点儿
      res[left][left] = counter++
    }
    // 更新left length width
    left++
    length--
    width--
  }
  return res
};

console.log(generateMatrix(4))
