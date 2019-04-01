function climb(i, n) {
  // 如果这是当前步数超过了n 无效
  if (i > n) {
    return 0;
  }
  // 当前步数等于n 有效
  if (i === n) {
    return 1;
  }
  // 遍历所有的1步和2步
  return climb(i + 1, n) + climb(i + 2, n);
}

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
  return climb(0, n);
};

/**
 * @param {number} n
 * @return {number}
 */
var climbStairs1 = function(n) {
  let dp_2 = 1, dp_1 = 2, dp;
  if (n === 2) return dp_2;
  else if (n === 1) return dp_1;
  for (let i = 3; i <= n; i++) {
    dp = dp_1 + dp_2;
    dp_2 = dp_1;
    dp_1 = dp;
    
  }
  return dp;
};

console.log(climbStairs1(4))