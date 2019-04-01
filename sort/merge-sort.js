/**
 * 归并排序
 * @param {Array} array 
 * @param {Number} start 开始位置
 * @param {Number} end 结束位置
 */
function mergeSort(array, start, end) {
  if (start >= end) return;
  let divide = Math.floor((start + end) / 2);
  mergeSort(array, start, divide);
  mergeSort(array, divide + 1, end);
  merge(array, start, divide + 1, end)
}

/**
 * 合并两个数组
 * @param {Array} array 
 * @param {Number} start 
 * @param {Number} mid 
 * @param {Number} end 
 */
function merge(array, start, divide, end) {
  let temp = [], recordStart = start, mid = divide;
  while (start < divide && mid <= end) {
    if (array[start] < array[mid]) {
      temp.push(array[start++]);
    } else {
      temp.push(array[mid++]);
    }
  }
  while (start < divide) {
    temp.push(array[start++])
  }
  while (mid <= end) {
    temp.push(array[mid++]);
  }
  for (let i = recordStart, j = 0; i <= end; i++, j++) {
    array[i] = temp[j]
  }
}
let a = [1, 32, 4, 21, 12, 21, 34, 124, 12]
mergeSort(a, 0, a.length - 1)
console.log(a)
