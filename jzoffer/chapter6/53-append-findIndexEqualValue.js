/**
 * 给定一个递增的数组 
 * 找到其中的任意一个 array[i] = i的数儿
 * @param {number[]} array 
 */
function findIndexEqualValue(array) {
  let i = 0, j = array.length - 1
  while (i <= j) {
    let mid = Math.floor((i + j) / 2)
    if (array[mid] < mid) {
    // 这个情况下 下标相等的一定在右边
      i = mid + 1
    } else if (array[mid] > mid) {
      j = mid - 1
    } else {
      return i
    }
  }
  return -1
}

console.log(findIndexEqualValue([-3,-1,1,3,5]))