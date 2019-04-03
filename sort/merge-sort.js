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
  // 对于小规模的数组 采用插入排序 或者 选择排序 更好
  // merge(array, start, divide + 1, end)
  // 对于array[mid] <= array[mid + 1] 认为已经有序
  if(array[divide] > array[divide + 1]) 
    selectSort(array, start, end)
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

/**
 * 
 * @param {Array} array 
 * @param {Number} start 开始插排的位置
 * @param {Number} end  结束插排的位置
 */
function selectSort(array, start, end) {
  for (let i = start; i <= end; i++) {
    let min = array[i];
    for (let j = i + 1; j <= end; j++) {
      if (min > array[j]) {
        min = array[j];
        array[j] = array[i];
        array[i] = min;
      }
    }
  }
}

/**
 * 自底向上的归并排序
 * @param {*} array 
 */
function mergeSortFBTT(array) {
  let n = array.length;
  for (let sz = 1; sz < n; sz *= 2) {
    for (let j = 0; j < n - sz; j += 2 * sz) {
      // 因为每次归并是 11归并成2  22归并成4 44归并成8 以此类推
      // 因此merge的时候 可以看到 子数组索引j每次增长2*SZ 即归并j到j+2*sz-1的两个子数组
      // 因此起始位置是J 中间位置是j+sz-1(因为我前面写得中间位置是在外面加一 所以这儿是j+sz) 末位位置因为不能超过数组长度 所以有n-1 
      merge(array, j, j + sz, Math.min(n - 1, j + sz + sz - 1))
    }
  }
}

let a = [1, 32, 4, 21, 12, 21, 34, 124, 12]
mergeSortFBTT(a)
console.log(a)
