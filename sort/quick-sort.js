/**
 * 
 * @param {Array} array 待排序的数组
 * @param {*} start 
 * @param {*} end 
 */
function quickSort(array, start, end) {
  if (start >= end) return;
  let j = partition(array, start, end);
  quickSort(array, start, j - 1);
  quickSort(array, j + 1, end)
}

/**
 * 把start位置的当做切分的数 
 * 从左指针开始 向右找到第一个 大于切分的数 从右指针开始 向左找到第一个小于它的数
 * 然后交换
 * 最后把切分的数 放到整理好的数组中间 即j的位置
 * @param {Array} array 
 * @param {*} start 
 * @param {*} end 
 */
function partition(array, start, end) {
  let i = start, j = end + 1;
  while (true) {
    while (array[++i] < array[start])
      // 防止越界
      if (i === end) break;
    while (array[--j] > array[start])
      if (j === start) break;
    if (i >= j) break;
    let temp = array[i]
    array[i] = array[j];
    array[j] = temp;
  }
  let temp = array[j];
  array[j] = array[start];
  array[start] = temp;
  return j;
}

let a = [1, 32, 4, 21, 12, 21, 34, 124, 12]
quickSort(a, 0, a.length - 1)
console.log(a)