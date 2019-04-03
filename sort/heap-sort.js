/**
 * 堆排序
 * @param {Array} array 是一个数组(已经是一个大顶堆) 保存了一个堆 如果一个堆的父节点的索引为K则其子节点为2K和2K+1 反之Math.floor(K/2) 其0位置不保存东西
 */
function heapSort(array) {
  let n = array.length - 1
  for (let i = Math.floor(n / 2); i >= 1; i--) {
    heapDown(array, i, n + 1)
  }
  while (n > 1) {
    let temp = array[1];
    array[1] = array[n];
    array[n--] = temp
    heapDown(array, 1, n + 1)
  }
}

/**
 * 
 * @param {Array} array 
 * @param {Number} k 当前需要上浮的数的索引
 */
function heapUp(array, k) {
  while (k > 1 && array[k] > array[Math.floor(k / 2)]) {
    let temp = array[k]
    array[k] = array[Math.floor(k / 2)]
    array[Math.floor(k / 2)] = temp
    k = Math.floor(k / 2);
  }
}

/**
 * 
 * @param {Array} array 
 * @param {Number} k 当前需要下沉的数的索引 
 * @param {Number} n 数组边界
 */
function heapDown(array, k, n) {
  while (2 * k < n) {
    let j = 2 * k;
    if (j < n - 1 && array[j] < array[j + 1]) j++;
    if (array[k] >= array[j]) break;
    let temp = array[j]
    array[j] = array[k];
    array[k] = temp;
    k = j;
  }
}

let array = [0, 5, 4, 3, 1, 2, 6, 7]
heapSort(array)
console.log(array)