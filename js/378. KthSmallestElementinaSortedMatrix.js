/**
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthSmallest1 = function(matrix, k) {
  let array = [];
  matrix.forEach((val) => {
    array = [...array, ...val]
  })
  mergeSort(array, 0, array.length - 1)
  console.log(array)
  return array[k - 1]
};

/**
 * 
 * @param {Array} array 
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
 * 
 * @param {Array} array 
 * @param {number} start 
 * @param {number} mid 
 * @param {number} end 
 */
function merge(array, start, mid, end) {
  let start2 = mid + 1, temp = [], recordStart = start
  while (start <= mid && start2 <= end) {
    if (array[start] >= array[start2])
      temp.push(array[start2++])
    else
      temp.push(array[start++])
  }
  while (start <= mid) {
    temp.push(array[start++])
  }
  while (start2 <= end) {
    temp.push(array[start2++])
  }
  for (let i = recordStart, j = 0; i <= end; i++, j++) {
    array[i] = temp[j]
  }
}

/**
 * 这道题还可以用二分法做
 * 因为其实整个可以拉通成一个完整的array
 * 但是有一个疑问就是他可以不是有序的
 * @param {number[][]} matrix
 * @param {number} k
 * @return {number}
 */
var kthSmallest = function(matrix, k) {

};

console.log(kthSmallest([
  [ 1,  5,  9],
  [10, 11, 13],
  [12, 13, 15]], 8))