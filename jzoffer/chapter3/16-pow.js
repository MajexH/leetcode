/**
 * 实现 次方的函数 不用在意 大数的问题
 * 主要考察边界条件
 * @param {number} base 
 * @param {number} exponent 
 */
function pow(base, exponent) {
  // 底数为0
  if (base === 0) return 0
  let bool = exponent < 0, res = 1
  // 这儿有更优的解法 可以做分解 因为 一个数的n次方 等于其 两个 n/2 次方相乘
  // for (let i = 1; i <= Math.abs(exponent); i++) {
  //   res *= base
  // }

  return bool ? 1 / res : res
}

function power(base, exponent) {
  if (n === 0) return 1
  if (n === 1) return base

  let res = power(base, exponent >> 1)

  res *= res
  // 奇数
  if (exponent % 2 === 1)
    res *= base
  return res
}