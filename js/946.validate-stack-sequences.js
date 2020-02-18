/*
 * @lc app=leetcode id=946 lang=javascript
 *
 * [946] Validate Stack Sequences
 */

// @lc code=start
/**
 * @param {number[]} inOrder
 * @param {number[]} outOrder
 * @return {boolean}
 */
var validateStackSequences = function(inOrder, outOrder) {
  let stack = []

  // 两个栈的指针
  let i = 0, j = 0
  // 把入栈压入栈顶 如果发现 入栈时头跟 出栈的头是一样
  // 说明现在这个时候该出栈 出栈即可
  for (i = 0; i < inOrder.length; i++) {
    if (inOrder[i] === outOrder[j]) {
      // 找到一个outOrder中的弹出元素了
      j++
      // 如果栈里面的 有相同的元素
      while (j < outOrder.length && stack.length > 0 && stack[stack.length - 1] === outOrder[j]) {
        stack.pop()
        j++
      }
    }
    else {
      stack.push(inOrder[i])
    }
  }
  return stack.length === 0
};
// @lc code=end

console.log(validateStackSequences([1,2,3,4,5], [4,5,3,2,1]))