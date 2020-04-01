/*
 * @lc app=leetcode id=150 lang=javascript
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
/**
 * @param {string[]} tokens
 * @return {number}
 */
var evalRPN = function(tokens) {
  let stack = [];
  for (let token of tokens) {
    switch (token) {
      case "+":
        // 失败
        if (stack.length < 2) return null;
        stack.push(stack.pop() + stack.pop());
        break;
      case "-":
        stack.push(-stack.pop() + stack.pop());
        break;
      case "*":
        stack.push(stack.pop() * stack.pop());
        break;
      case "/":
        let res = 1 / (stack.pop() / stack.pop())
        if (res > 0)
          stack.push(Math.floor(res));
        else 
          stack.push(Math.ceil(res))
        break;
      default:
        stack.push(Number.parseFloat(token));
    }
  }
  return stack.pop();
};
// @lc code=end
console.log(evalRPN(["4","3","-"]));
