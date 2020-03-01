/**
 * 给定一个n 求第n位的丑数
 * 丑数的定义是 只包含因子 2 3 5的数字
 * 因此 丑数去不停地除以2 3 5 最后余数为0 就是丑数
 * @param {number} n 
 */
function getUglyNumber(n) {
  // 保存所有的丑数
  let array = Array(n)
  // 规定1是第一个丑数
  array[0] = 1
  // t2 t3 t5分别代表一个分界点
  // 也就是 2 * t2 > max(max是当前最大的丑数)
  let t2 = t3 = t5 = 0
  for (let index = 1; index < n; index++) {
    // 丑数肯定是某个的丑数 乘2 3 5的结果
    array[index] = Math.min(2 * array[t2], 3 * array[t3], 5 * array[t5])
    // 根据当前的最大的丑数 更新值
    while (2 * array[t2] <= array[index]) {
      t2++
    }
    while (3 * array[t3] <= array[index]) {
      t3++
    }
    while (5 * array[t5] <= array[index]) {
      t5++
    }
  }
  return array[n - 1]
}

console.log(getUglyNumber(11))