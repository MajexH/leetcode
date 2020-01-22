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

console.log(searchNumberInMatrix(
  [[1,2,8,9],
   [2,4,9,12],
   [4,7,10,13],
   [6,8,11,15]], 7)
)