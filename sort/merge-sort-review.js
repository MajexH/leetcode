/**
 * 归并排序是典型的分治法
 * 通过递归是不断的缩小需要排序的空间 
 * @param {number[]} array 
 * @param {number} start 
 * @param {number} end 
 */
function mergeSort(array, start, end) {
  if (start >= end) return
  let mid = Math.floor((start + end) / 2)
  mergeSort(array, start, mid)
  mergeSort(array, mid + 1, end)
  merge(array, start, mid, end)
}

/**
 * 这个地方还可以用更多的方法来进行归并
 * 这儿使用的是简单的归并
 * @param {number[]} array 
 * @param {number} start 
 * @param {number} mid 
 * @param {number} end 
 */
function merge(array, start, mid, end) {
  let temp = [], i = start, j = mid + 1
  while (i <= mid && j <= end) {
    if (array[i] < array[j]) temp.push(array[i++])
    else temp.push(array[j++])
  }
  while (i <= mid) temp.push(array[i++])
  while (j <= end) temp.push(array[j++])
  for (let index = start, indexT = 0; index <= end; index++, indexT++) {
    array[index] = temp[indexT]
  }
}

let a = [1,4,2,3,6,5,9,65,5,78,10]
mergeSort(a, 0, a.length - 1)
console.log(a)