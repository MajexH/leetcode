
/**
 * 找到 1- n当中1出现的次数
 * 这个1的次数 是包含所有的1 也就是 111 算 3次1
 * @param {Number} n 
 */
function findThe1Frequence(n) {
  // 转换成数组
  let array = n.toString().split('')
  return recursion(array)
}

/**
 * 
 * @param {Array} array 
 */
function recursion(array) {
  if (array.length <= 0 || array === null)
    return 0
  
  let first = array[0]

  // 边界条件
  if (array.length === 1) {
    if (first === 1)
      return 1
    else
      // 其它 0 2 - 9的情况只有0
      return 0
  }
  
  let firstNumberCount = 0, otherNumberCount = 0
  // 计算首位为1的时候的 有多少一个1
  if (first > 1)
    firstNumberCount = Math.pow(10, array.length - 1)
  else if (first === 1) {
    // 当首位为1时 说明从 这个首位为1的不可能达到上个分支那么多 只有可能存在有 其大小 到 首位为1 后面权威0的数的这么多
    // 加一是因为还有首位的一个数
    let temp = array
    temp.shift()
    firstNumberCount = Number.parseInt(temp.join('')) + 1
  }
  // 计算当首位固定的时候 其它位置的数量
  // 也就是在剩下的位置里面选择 一位成为1 其它的在0-9 10个数字中任意选择
  // c(n-1)1 * 10^(n - 2)
  // 而以上这种情况 可以出现 first次
  otherNumberCount = first * (array.length - 1) * Math.pow(10, array.length - 2)
  array.shift()
  let recursionNumberCount = recursion(array)
  return firstNumberCount + otherNumberCount + recursionNumberCount
}

console.log(findThe1Frequence(21345))