/**
 * 调整一个数组 使其 数组 左边为奇数 右边为偶数
 * 采用快排的双指针 思想
 * @param {Array} array 
 */
function addjustArray(array) {
  let i = 0, j = array.length - 1
  while (i < j) {
    // 左指针指向奇数
    if (array[i] & 1 !== 0) {
      i++
      continue
    }
    // 如果右指针指向偶数
    if (array[j] & 1 === 0) {
      j--
      continue
    }
    let temp = array[i]
    array[i] = array[j]
    array[j] = temp
    i++
    j--
  }
}

let array = [1,2,3,4,5]
addjustArray(array)
console.log(array)
