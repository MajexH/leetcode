/**
 * 这个方法 采用带备忘录的递归实现
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var findMaxForm1 = function(strs, m, n) {
  return recursion(strs, 0, m, n, new Map())
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
 * @param {Map} memo
 */
function recursion(strs, index, m, n, memo) {
  // 边界条件
  if (index === strs.length) {
    // 循环到底 返回0
    return 0
  }
  if (!memo.has(index + '-' + m + '-' + n)) {
    // let notChoose = 
    let temp = getZerosAndOnes(strs[index])
    // 选择当前数
    let choose = (m < temp[0] || n < temp[1]) ? 0 : recursion(strs, index + 1, m - temp[0], n - temp[1], memo) + 1
    // 不选择当前数
    memo.set(index + '-' + m + '-' + n, Math.max(recursion(strs, index + 1, m, n, memo), choose))
  }
  return memo.get(index + '-' + m + '-' + n)
}

/**
 * 这个思路也很简单 通过dp来保存当前每个状态的值
 * 首先明白状态转移方程 Max(dp[i][j], dp[i-zeors][j-ones] + 1)
 * 因为 就是要比较当前 是否需要加入这个字符串 加入这个字符串的话 则承载会变小（会到上个状态） 就是dp[i-zeors][j-ones] 加一 是因为 加入了现在这个字符串 
 * 其中的三个循环表示
 * 第一个循环 循环所有的str 
 * 第二三个循环 循环建立dp
 * dp[i][j] 就是表示了 当前用i个0和j个1 能够建立的所有 str 因为遍历了所有str 所以一个一个str遍历下去 就行
 * Definition: dp[i][j] = the number of strings we can form with j number of 1's and i number of 0's. (这个十分重要)
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var findMaxForm = function(strs, m, n) {
  let dp = Array(m)
  for (let i = 0; i < m + 1; i++) {
    dp[i] = Array(n + 1).fill(0)
  }
  for (let str of strs) {
    let temp = getZerosAndOnes(str)
    for (let i = m; i >= temp[0]; i--) {
      for (let j = n; j >= temp[1]; j--) {
        if (i >= temp[0] && j >= temp[1]) {
          dp[i][j] = Math.max(dp[i][j], dp[i - temp[0]][j - temp[1]] + 1)
        }
      }
    }
    console.log(dp)
  }
  
  return dp[m][n]
};

console.log(findMaxForm(["10", "0001", "111001", "1", "0"], m = 5, n = 3))