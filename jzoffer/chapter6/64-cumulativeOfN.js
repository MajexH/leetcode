/**
 * 求1到n的累加和
 * 不能用 循环、判断、乘除法
 * `````不会
 * 看了题解之后
 * 使用短路原则 即 && 语句第一个返回 false 第二个不会执行
 * @param {number} n 
 */
function cumulative(n) {
  return recursion(n)
}

function recursion(n) {
  let sum = n
  // 当n为0的时候 后面就不需要计算了
  n > 0 && ((sum += recursion(n - 1)) > 0)
  return sum
}
