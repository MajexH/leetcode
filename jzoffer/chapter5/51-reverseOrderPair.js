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