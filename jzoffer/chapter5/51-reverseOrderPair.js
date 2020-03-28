/**
 * 找到这个数组中的逆序对的个数
 * @param {Array} array 
 */
function getReverseOrderPair(array) {
  return mergeSort(array, 0, array.length - 1)
}

/**
 * 
 * @param {Array} array 
 * @param {Number} start 
 * @param {Number} end 
 */
function mergeSort(array, start, end) {
  if (start >= end) return 0
  let mid = Math.floor((start + end) / 2)
  // 为什么这里left right res 需要三部分加起来
  // 因为left只统计了到 start -> mid 为止的逆序对 right 统计了mid -> end 的逆序对
  // 即使现在 left right 已经在自己的内部有序了
  // 但是 left 和 right 最后合并的 时候 仍然在两个部分 合并的时候存在 逆序对
  // 所以需要把三部分加起来
  let left = mergeSort(array, start, mid)
  let right = mergeSort(array, mid + 1, end)
  let res = merge(array, start, mid, end)
  return left + right + res
}

/**
 * 
 * @param {Array} array 
 * @param {Number} start 
 * @param {Number} mid 
 * @param {Number} end 
 * @returns {Number} 代表这个数组里面的逆序对的个数
 */
function merge(array, start, mid, end) {
  // res表示逆序对数
  let res = 0
  let temp = []
  let i = start, j = mid + 1
  while (i <= mid && j <= end) {
    if (array[i] <= array[j]) {
      temp.push(array[i++])
    } else {
    // 这个地方就是逆序对
      res++
      temp.push(array[j++])
    }
  }
  while (i <= mid) {
    temp.push(array[i++])
  }
  while (j <= end) {
    temp.push(array[j++])
  }
  for (let index = start, j = 0; index <= end; index++, j++) {
    array[index] = temp[j]
  }
  return res
}

console.log(getReverseOrderPair([1,2,4,5,3]))