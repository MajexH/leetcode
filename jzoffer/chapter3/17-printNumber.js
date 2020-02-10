/**
 * 打印重1开始的，到最大的n位十进制数
 * 如n = 3，则打印 1 - 999
 * 因为n可能很大 因此要考虑 大数问题
 * @param {number} n 
 */
function printNumber(n) {
  let array = Array(n).fill(0)
  while (addOne(array)) {
    console.log(print(array))
  }
}

/**
 * 
 * @param {Array} input 
 */
function addOne(input) {
  // 为了防止溢出
  let array = [...input]
  let add = 1
  for (let i = array.length - 1; i >= 0; i--) {
    // 进位为0 则不需要再继续了
    if (add === 0) break
    let temp = array[i] + add
    array[i] = temp % 10
    add = Math.floor(temp / 10)
  }
  // 如果出来还多了一位 说明已经溢出
  if (add !== 0) return false
  // js中这样直接赋值是不行的 因为 input 代表一个指针 现在 传递进来的input的指针呗指向了另外一个array 所以 找不到了
  // input = array 这样是不行的
  // 因此 只能直接操作input数组
  for (let i = 0, j = 0; i < array.length; i++, j++) {
    input[i] = array[j]
  }
  return true
}

function print(array) {
  let flag = false, res = ''
  for (let i = 0; i < array.length; i++) {
    if (!flag && array[i] !== 0) {
      flag = true
    }
    if (flag) res = res + array[i]
  }
  return res
}

// console.log(printNumber(5))

/**
 * 利用全排列的思想来生成 1-n位数的所有结果
 * 其实 要打印 1-n位数 其中的每一位都是0-9的数字的排列 因此 只要找到整个的全排列即可
 * @param {Number} n 
 */
function printNumberWithPermutation(n) {
  let array = Array(n)
  recursion(n, 0, array)
}

function recursion(n, start, array) {
  if (start === n) {
    console.log(print(array))
    return
  }
  for (let i = 0; i < 10; i++) {
    array[start] = i
    recursion(n, start + 1, array)
  }
}

printNumberWithPermutation(3)