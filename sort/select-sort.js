/**
 * 选择排序
 * @param {Array} array 
 */
function selectSort(array) {
  for (let i = 0; i < array.length; i++) {
    let min = array[i];
    for (let j = i + 1; j < array.length; j++) {
      if (min > array[j]) {
        min = array[j];
        array[j] = array[i];
        array[i] = min;
      }
    }
  }
  return array;
}

console.log(selectSort([1, 32, 4, 21, 12, 21, 34, 124, 12]))