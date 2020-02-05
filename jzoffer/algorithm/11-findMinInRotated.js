/**
 * 找到一个旋转数组中的最小数
 * 这个旋转数组是一个递增数组在一个点折后的结果
 * 旋转数组中没有重复
 * related to leetcode 153
 * @param {Array} array 
 * @returns {number}
 */
function findMinimumNumberInRotatedArray(array) {
  if (array.length === 2) { return Math.min(...array) }
  let i = 0, j = array.length - 1
  while (i < j - 1) {
    let mid = Math.floor((i + j) / 2)
    if (array[mid] < array[i]) {
      // 异常情况 说明拐点在左边
      // 因为mid可能是最小的点
      j = mid
    } else if (array[mid] > array[j]) {
      // 异常情况
      i = mid
    } else {
      // 说明这个是一个完全的递增数列
      return array[0]
    }
  }
  return array[j]
}

/**
 * 找到一个旋转数组中的最小数
 * 这个旋转数组是一个递增数组在一个点折后的结果
 * 旋转数组中有重复
 * related to leetcode 154
 * @param {Array} array 
 * @returns {number}
 */
function findMinimumNumberInRotatedArrayWithDuplicate(array) {
  if (array.length === 2) { return Math.min(...array) }
  let i = 0, j = array.length - 1
  while (i < j - 1) {
    let mid = Math.floor((i + j) / 2)
    if (array[mid] === array[i] && array[mid] === array[j]) {
      // 这种情况 无法判断拐点在哪儿 因此直接顺序查找
      let min = Number.MAX_SAFE_INTEGER
      for (;i < j; i++) {
        min = Math.min(array[i], min)
      }
      return min
    } else if (array[mid] < array[i]) {
      // 异常情况 说明拐点在左边
      // 因为mid可能是最小的点
      j = mid
    } else if (array[mid] > array[j]) {
      // 异常情况
      i = mid
    } else {
      // 说明这个是一个完全的递增数列
      return array[0]
    }
  }
  return array[j]
}

console.log(findMinimumNumberInRotatedArray([2,2,2,0,1]))