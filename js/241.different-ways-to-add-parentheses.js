/*
 * @lc app=leetcode id=241 lang=javascript
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
/**
 * @param {string} input
 * @return {number[]}
 */
var diffWaysToCompute = function(input) {
  return recursion(input, 0, input.length - 1)
};

/**
 * 
 * @param {string} input 
 * @param {number} start
 * @param {number} end
 */
function recursion(input, start, end) {
  let temp = [], isNumber = true
  for (let i = start; i <= end; i++) {
    if (input.charAt(i) === '*' || input.charAt(i) === '-' || input.charAt(i) === '+') {
      isNumber = false
      let lefts = recursion(input, start, i - 1), rights = recursion(input, i + 1, end)
      for (let left of lefts) {
        for (let right of rights) {
          switch (input.charAt(i)) {
            case '-':
              temp.push(left - right)
              break
            case '+':
              temp.push(left + right)
              break
            case '*':
              temp.push(left * right)
              break
          }
        }
      }
    }
  }
  if (isNumber) temp.push(Number.parseInt(input.substring(start, end + 1)))
  return temp
}
// @lc code=end
console.log(diffWaysToCompute('2*3-4*5'))