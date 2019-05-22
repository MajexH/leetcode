/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
  let array = []
  for (let i = 0; i < m; i++) {
    array[i] = Array(n).fill(-1);
  }
  array[0][0] = 1
  recursion(m - 1, n - 1, array)
  return array[m - 1][n - 1]
};

/**
 * 为什么考虑他是一个dp问题呢
 * 因为其实你走了一步之后，他肯定是在下一个更小的矩阵里面走然后每走一个都是一个更小的矩阵
 * 直到最后到达终点，因此 是一个dp问题
 * 既然是一个dp问题 肯定是递归的 而采用直接递归 超时 所以采用了带备忘录的递归
 * memo里面存储的是这个地方要多少步数才能到达终点
 * 为了方便 其实我是从终点出发的
 * @param {*} m 
 * @param {*} n 
 */
function recursion(m, n, memo) {
  if (m < 0 || n < 0)
    return 0
  if (memo[m][n] !== - 1)
    return memo[m][n];
  memo[m][n] = recursion(m - 1, n, memo) + recursion(m, n - 1, memo);
  return memo[m][n]
}

console.log(uniquePaths(1, 2))