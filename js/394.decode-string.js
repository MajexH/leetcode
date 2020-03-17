/*
 * @lc app=leetcode id=394 lang=javascript
 *
 * [394] Decode String
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
  let stack = [], res = ''
  for (let char of s) {
    if (char === ']') {
      // 说明成对了
      // pop 到第一个 数字
      let temp = ''
      let top = stack[stack.length - 1]
      while (top !== '[') {
        temp = top + temp
        stack.pop()
        top = stack[stack.length - 1]
      }
      stack.pop()
      top = stack[stack.length - 1]
      // 说明找到了第一个数字
      // 将数组组成一个完整的数字
      let number = ''
      while (top !== '[' && checkNumber(top)) {
        number = top + number
        stack.pop()
        if (stack.length === 0) break
        top = stack[stack.length - 1]
      }
      let res = ''
      for (let i = 0; i < Number.parseInt(number); i++) {
        res += temp
      }
      stack.push(res === '' ? temp : res)
    } else {
      stack.push(char)
    }
  }
  return stack.join('')
};

function checkNumber(char) {
  let integer = Number.parseInt(char)
  return integer >= 0
}
// @lc code=end

console.log(decodeString('2[abc]3[cd]ef'))