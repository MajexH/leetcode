/**
 * @param {number[][]} triangle
 * @return {number}
 */
var minimumTotal = function(triangle) {
  // 这个三角形每一行都有当前行数+1个长度
  let memo = [], max = triangle.length - 1
  for (let i = 0; i <= max; i++) {
    memo[i] = Array(i + 1).fill(-1)
  }
  return recursion(triangle, 0, 0, memo)
};

/**
 * 
 * @param {number[][]} triangle 
 * @param {number} curx 
 * @param {number} cury 
 * @param {number[][]} memo 
 */
function recursion(triangle, curx, cury, memo) {
  if (curx >= triangle.length || cury > curx) 
    return 0
  if (memo[curx][cury] !== - 1)
    return memo[curx][cury]
  memo[curx][cury] = Math.min(recursion(triangle, curx + 1, cury, memo), recursion(triangle, curx + 1, cury + 1, memo)) + triangle[curx][cury] 
  return memo[curx][cury]
}

console.log(minimumTotal([
  [2],
 [3,4],
[6,5,7],
[4,1,8,3]
]))