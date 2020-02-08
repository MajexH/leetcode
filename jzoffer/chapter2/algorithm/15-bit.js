/**
 * 拿到number中的2进制的1的个数
 * @param {number} number 
 */
function getCountOfNumberOneInBit(number) {
  let counter = 0
  while (number !== 0) {
    if (number & 1) counter++
    // 采用无符号右移 避免负数的时候 死循环
    number >>>= 1
  }
  return counter
}

/**
 * 采用左移的思想 针对number的每一位进行判断
 * @param {number} number 
 */
function getCountOfNumberOneInBitIndexLeft(number) {
  let index = 1, counter = 0
  while (index) {
    if (number & index) counter++
    // 将与数左移
    index <<= 1
  }
  return counter
}

/**
 * 利用 (n - 1) & n 会将数字最右边的1变成0 
 * @param {number} number 
 */
function getCountOfNumberOneInBitUseAnd(number) {
 let counter = 0
 while (number) {
   counter++
   number = number & (number - 1)
 }
 return counter
}

console.log(getCountOfNumberOneInBit(-1))
console.log(getCountOfNumberOneInBitIndexLeft(-1))
console.log(getCountOfNumberOneInBitUseAnd(-1))