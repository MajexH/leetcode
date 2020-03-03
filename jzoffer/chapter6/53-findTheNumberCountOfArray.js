/**
 * 统计一个 排序 数组中的numer出现的次数
 * @param {number[]} array
 * @param {number} number
 */
function findTheNumberCountOfArray(array, number) {
  // 因为是排序的 所以用二分
  // 其中 i 找到数组中第一次出现的位置
  // j找到数组中最后一次出现的位置
  let i = binarySearchLeft(array, number)
  let j = binarySearchRight(array, number)
  return j - i + 1
}

/**
 * 寻找其最开始 和 最后的出现的地方
 * @param {number[]} array 
 * @param {number} target
 */
function binarySearchLeft(array, target) {
  let start = 0, end = array.length - 1
  while (start < end - 1) {
    let mid = Math.floor((start + end) / 2)
    if (array[mid] > target) {
      end = mid - 1
    } else if (array[mid] < target) {
      start = mid + 1
    } else {
    // 因为要寻找第一个 所以需要考虑
      end = mid
    }
  }
  if (array[start] === target)
    return start
  else 
    return end
}

function binarySearchRight(array, target) {
  let start = 0, end = array.length - 1
  while (start < end - 1) {
    let mid = Math.floor((start + end) / 2)
    if (array[mid] > target) {
      end = mid - 1
    } else if (array[mid] < target) {
      start = mid + 1
    } else {
      start = mid
    }
  }
  if (array[end] === target)
    return end
  else
    return start
}

console.log(findTheNumberCountOfArray([1,2,3,3,3,3,4,5], 3))