/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function(nums) {
  mergeSort(nums, 0, nums.length - 1)
  return nums
};

function mergeSort(array, start, end) {
  if (start >= end) return 
  let mid = Math.floor((start + end) / 2)
  mergeSort(array, start, mid)
  mergeSort(array, mid + 1, end)
  merge(array, start, mid, end)
}

function merge(array, start, mid, end) {
  // 第一个子数组是从start开始 第二个子数组是从mid + 1开始
  let temp = [], i = start, j = mid + 1
  while (i <= mid && j <= end) {
    if (array[i] < array[j]) temp.push(array[i++])
    else temp.push(array[j++])
  }
  while (i <= mid) { temp.push(array[i++]) }
  while (j <= end) { temp.push(array[j++]) }
  for (let count1 = start, count2 = 0; count1 <= end; count1++, count2++) {
    array[count1] = temp[count2]
  }
}

console.log(sortArray([5, 2, 3, 1]))