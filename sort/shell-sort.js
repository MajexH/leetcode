
/**
 * 希尔排序 有步长的插入排序
 * @param {Array} array 
 * 
 */
function shellSort(array) {
  // 取步长为n / 2
  let h = Math.floor(array.length / 2)
  while (h >= 1) {
    for (let i = h; i < array.length; i++) {
      let exchange = array[i];
      let j = i - h;
      for (; j >= 0 && exchange < array[j]; j -= h) {
        array[j + h] = array[j]
      }
      array[j + h] = exchange
    }
    // 缩小步长
    h = Math.floor(h / 2)
  }
  return array
}

console.log(shellSort([1, 32, 4, 21, 12, 21, 34, 124, 12]))