/**
 * 在一个二维数组里面查找一个数
 * 这个二维数组满足 每一行都是递增的 每一列都是递增的
 * @param {Array[]} array 
 * @param {Number} target 
 * @returns {boolean}
 */
function searchNumberInMatrix(array, target) {
  for (let i = 0; i < array.length; i++) {
    if (array[i][0] <= target && array[i][array[i].length - 1] >= target) {
      let res = binarySearch(array[i], target)
      if (res !== -1) return true
    }
  }
  return false
}

/**
 * 二分 找到返回target自己 否则返回-1
 * @param {Array} array 
 * @param {number} target
 * @returns {number}
 */
function binarySearch(array, target) {
  let start = 0, end = array.length - 1
  while (start < end) {
    let mid = Math.floor((start + end) / 2)
    if (array[mid] < target) {
      start = mid + 1
    } else if (array[mid] > target) {
      end = mid - 1
    } else {
      // 二分查找找到
      return array[mid]
    }
  }
  return -1
}

/**
 * 书上的示例代码
 * 主要的思想是从整个矩阵的右上角出发
 * 如果当前的右上角的数大于target
 * 则说明则说明不可能在这一列 但是可能在左边
 * 如果有商家的数 小于target
 * 则说明不可能在这一行 因为是从右上角往下缩的缩小范围
 * @param {Array[]} matrix 
 */
function searchNumberInMatrixSample(matrix, target) {
  let rows = matrix.length - 1, cols = matrix[0].length - 1
  let curRow = 0, curCol = cols

  while (curRow <= rows && curCol >= 0) {
    if (matrix[curRow][curCol] === target) {
      console.log(curRow, curCol)
      return true
    } else if (matrix[curRow][curCol] < target) {
      ++curRow
    } else {
      --curCol
    }
  }
}

console.log(searchNumberInMatrix(
  [[1,2,8,9],
   [2,4,9,12],
   [4,7,10,13],
   [6,8,11,15]], 7)
)

console.log(searchNumberInMatrixSample(
  [[1,2,8,9],
   [2,4,9,12],
   [4,7,10,13],
   [6,8,11,15]], 7)
)