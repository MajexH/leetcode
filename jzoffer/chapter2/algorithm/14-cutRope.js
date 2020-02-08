/**
 * 跟另外一个不同的是 这个地方不限定剪绳子的次数 只需要找到最大的值即可
 * @param {Number} n 绳子长度
 * @returns {Number} 最优结果
 */
function cutRope(n) {
  return recursion(n, 0, false)
}

/**
 * 
 * @param {Number} n 
 * @param {Number} start 
 * @param {boolean} flag 表示当前的递归中 是否已经切割过 因为在访问 后续的节点中的时候 需要根据这个去判断 前面是否切割过 因为存在必须 切割一次的要求
 */
function recursion(n, start, flag) {
  if (start >= n) return 1
  let res = Number.MIN_SAFE_INTEGER
  for (let i = start + 1; i < n; i++) {
    res = Math.max(res, (i - start) * recursion(n, i, true))
  }
  if (flag) res = Math.max(res, n - start)
  return res
}

function cutRopeWithoutRecurision(n) {
  if (n === 2) {
    return 1
  }
  if (n === 3) 
    return 2
  let array = Array(n + 1)
  array[0] = 0
  array[1] = 1
  array[2] = 2
  array[3] = 3
  for (let i = 4; i <= n; i++) {
    let max = Number.MIN_SAFE_INTEGER
    // 遍历到 i / 2是因为 前面一半 和后面一半 其实是一样的 反过来的
    // i表示 当前的长度
    for (let j = 1; j <= Math.floor(i / 2); j++) {
      max = Math.max(max, array[j] * array[i - j])
    }
    array[i] = max
  }
  return array[n]
}

console.log(2, cutRopeWithoutRecurision(2))
console.log(3, cutRopeWithoutRecurision(3))
console.log(4, cutRopeWithoutRecurision(4))
console.log(5, cutRopeWithoutRecurision(5))
console.log(6, cutRopeWithoutRecurision(6))
console.log(7, cutRopeWithoutRecurision(7))
console.log(8,cutRopeWithoutRecurision(8))
console.log(9,cutRopeWithoutRecurision(9))
console.log(10,cutRopeWithoutRecurision(10))
console.log(11,cutRopeWithoutRecurision(11))
console.log(50,cutRopeWithoutRecurision(50))