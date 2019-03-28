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

console.log(climbStairs(44))