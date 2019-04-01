/**
 * 插入排序
 * @param {Array} array 
 */
function insertSort(array) {
  for (let i = 1; i < array.length; i++) {
    let exchange = array[i];
    let j = i - 1;
    for (; j >= 0; j--) {
      if (exchange > array[j]) {
        break;
      } else {
        array[j + 1] = array[j];
      }
    }
    array[j + 1] = exchange;
  }
  return array
}

console.log(insertSort([1, 32, 4, 21, 12, 21, 34, 124, 12]))