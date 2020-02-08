/**
 * 一条长度为n的绳子剪成m段
 * 每段的长度记为k[0]---k[m]
 * 求 k[0] * k[1] * --- * k[m]的最大乘积是多少
 * @param {Number} n
 * @param {Number} m
 */
function cutRope(n, m) {
  let memo = Array(n + 1).fill(-1)
  recursion(n, m - 1, 0, 0, memo)
  return memo[0]
}

// TODO: 这个地方也有问题
function recursion(n, m, start, index, memo) {
  // 如果切到最后一刀 返回 剩下的长度
  if (index === m) {
    return n - start
  }
  // 越界
  if (start >= n) return 1
  if (memo[start] !== -1) return memo[start]
  let res = Number.MIN_SAFE_INTEGER
  for (let i = start + 1; i <= n; i++) {
    res = Math.max((i - start) * recursion(n, m, i, index + 1, memo), res)
  }
  memo[start] = res
  return res
}

console.log(cutRope(7, 3))