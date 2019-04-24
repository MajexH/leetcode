/**
 * @param {number} n
 * @return {number}
 */
var numTrees = function(n) {
  return recursion(n)
};

/**
 * 实际上求一个unique的tree即求选一个作为根剩下的所有数做一个BST
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