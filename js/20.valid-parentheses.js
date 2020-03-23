/*
 * @lc app=leetcode id=20 lang=javascript
 *
 * [20] Valid Parentheses
 */

// @lc code=start
/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  let stack = []
  for (let char of s) {
    if (char === '(' || char === '{' || char === '[') {
      stack.push(char)
    } else {
      if ((char === ')' && stack[stack.length - 1] === '(') ||
          (char === ']' && stack[stack.length - 1] === '[') ||
          (char === '}' && stack[stack.length - 1] === '{'))
          stack.pop()
      else
        return false
    }
  }
  return stack.length === 0
};
// @lc code=end

console.log(isValid("()"))
console.log(isValid("()[]{}"))
console.log(isValid("(]"))
console.log(isValid("([)]"))