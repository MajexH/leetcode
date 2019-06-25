/**
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var findMaxForm = function(strs, m, n) {
  return recursion(strs, 0, m, n, 0, new Map())
};

/**
 * 
 * @param {string} str 
 */
function getZerosAndOnes(str) {
  let zeros = 0, ones = 0
  for (let item of str) {
    if (item === '0') {
      zeros++
    } else {
      ones++
    }
  }
  return [zeros, ones]
}

/**
 * 只要比较 每层选择这个数 和 不选择这个数 二者中的max
 * @param {string[]} strs 
 * @param {number} index 
 * @param {number} m 
 * @param {number} n 
 * @param {number} count
 * @param {Map} memo
 */
function recursion(strs, index, m, n, count, memo) {
  // 边界条件
  if (index === strs.length) {
    // 把当前的选择的count直接返回
    memo.set(m + '-' + n, count)
    return count
  }
  if (memo.has(m + '-' + n)) {
    return memo.get(m + '-' + n)
  }
  let temp = getZerosAndOnes(strs[index])
  let choose = Number.MIN_SAFE_INTEGER
  // 还有边界条件就是 m n 不够减了
  if (m >= temp[0] && n >= temp[1]) {
    // 选择当前数
    choose = recursion(strs, index + 1, m - temp[0], n - temp[1], count + 1, memo)
  }
  // 不选择当前数
  memo.set(m + '-' + n, Math.max(recursion(strs, index + 1, m, n, count, memo), choose))
  return memo.get(m + '-' + n)
}

console.log(findMaxForm(["10","0","1"], 1, 1))