/**
 * 快排仍然是采用分治法
 * 只是跟归并排序的分治法不同
 * @param {number[]} array 
 * @param {number} start 
 * @param {number} end 
 */
function quickSort(array, start, end) {
  if (start >= end) return
  let j = partition(array, start, end)
  // j是分界点 一次相当于找到一个数的位置
  quickSort(array, start, j - 1)
  quickSort(array, j + 1, end)
}

/**
 * partition函数 主要的工作就是根据一个划分的数儿 
 * 将数组分为两个部分
 * 再不断的缩小两个部分 最后完成
 * @param {number[]} array 
 * @param {number} start 
 * @param {number} end 
 */
function partition(array, start, end) {
  // 选第一个数作为奇数
  let base = array[start], i = start, j = end + 1
  while (true) {
    // 从左找到第一个大于base的数儿
    while (array[++i] < base) if (i === end) break
    // 从右找到第一个小于base的数儿
    while (array[--j] > base) if (start === j) break
    if (i >= j) break
    let temp = array[i]
    array[i] = array[j]
    array[j] = temp
  }
  array[start] = array[j]
  array[j] = base
  return j
}

let a = [1, 32, 4, 21, 12, 21, 34, 124, 12]
quickSort(a, 0, a.length - 1)
console.log(a)