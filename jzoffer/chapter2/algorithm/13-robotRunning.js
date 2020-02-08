/**
 * 一个m * n大小的格子
 * 一个机器人从左上出发 能够达到的格子数有多少，达到的条件是格子的 坐标的各位数字之和 不能超过一个给定的值
 * 机器人的行走方向是 上下左右
 * TODO: 实际上在
 * @param {number} m
 * @param {number} n
 * @param {number} threshold
 * @returns {number}
 */
function robotGetPlace(m, n, threshold) {
  // 用来记录能够到达的点
  let memo = Array(m)
  for (let i = 0; i < n; i++) {
    memo[i] = Array(n).fill(false)
  }
  recursion(m, n, threshold, 0, 0, memo)
  let res = 0
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (memo[i][j]) res++
    }
  }
  return res
}

/**
 * 
 * @param {number} m 
 * @param {number} n 
 * @param {number} threshold 
 * @param {number} currentX
 * @param {number} currentY
 * @param {Array} memo
 */
function recursion(m, n, threshold, currentX, currentY, memo) {
  // 越界 或者 memo已经是可以走通的了 就不用再看了
  if (currentX < 0 || currentX >= m || currentY < 0 || currentY >= n || checkXY(currentX, currentY, threshold) || memo[currentX][currentY])
    return
  // 表示 m n这个点 可以达到
  memo[currentX][currentY] = true
  recursion(m, n, threshold, currentX + 1, currentY, memo)
  recursion(m, n, threshold, currentX - 1, currentY, memo)
  recursion(m, n, threshold, currentX, currentY + 1, memo)
  recursion(m, n, threshold, currentX, currentY - 1, memo)
}

/**
 * 超过限界返回true
 * @param {number} currentX 
 * @param {number} currentY 
 * @param {number} threshold 
 * @returns {boolean}
 */
function checkXY(currentX, currentY, threshold) {
  return getNumber(currentX) + getNumber(currentY) > threshold
}

function getNumber(num) {
  let res = 0
  while (num !== 0) {
    res += num % 10
    num = Math.floor(num / 10)
  }
  return res
}

console.log(robotGetPlace(6, 6, 3))