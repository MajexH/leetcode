/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
  let memo = Array(n + 1).fill(0)
  memo[0] = 1
  memo[1] = 1
  for (let i = 2; i <= n; i++) {
    for (let j = 1; j <= i; j++) {
      memo[i] += memo[i - j] * memo[j - 1]
    }
  }
  return memo[n]
};

/**
 * 实际上求一个unique的tree即求选一个作为根剩下的所有数做一个BST
 * 即选定一个值作为根
 * 然后 左右子树 的数量 相乘即可（因为 排列组合）
 * @param {number} n 
 * @param {Array} array
 */
function recursion(n) {
  if (n <= 1) return 1
  let sum = 0
  for (let i = 1; i <= n; ++i) {
    sum += recursion(i - 1) * recursion(n - i)
  }
  return sum
}

console.log(numTrees(3))