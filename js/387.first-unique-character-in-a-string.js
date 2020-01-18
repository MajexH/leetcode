/*
 * @lc app=leetcode id=387 lang=javascript
 *
 * [387] First Unique Character in a String
 */

 /**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar1 = function(s) {
  let map = new Map(), stack = []
  for (let index = 0; index < s.length; index++) {
    let char = s.charAt(index)
    if (!map.has(char)) {
      stack.push(index)
      map.set(char, stack.length - 1)
    } else {
      let stackIndex = map.get(char)
      // 说明是第二次访问
      if (s.charAt(stack[stackIndex]) === char) {
        stack[stackIndex] = -1
      }
    }
  }
  for (let i = 0; i < stack.length; i++) {
    if (stack[i] !== -1) return stack[i]
  }
  return -1
};

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
  let map = new Map()
  for (let i = 0; i < s.length; i++) {
    let char = s.charAt(i)
    if (map.has(char)) {
      map.set(char, map.get(char) + 1)
    } else {
      map.set(char, 0)
    }
  }
  for (let i = 0; i < s.length; i++) {
    if (map.get(s.charAt(i)) === 0) {
      return i
    }
  }
  return -1
};
// @lc code=end

// console.log(firstUniqChar('leetcode'))
console.log(firstUniqChar('loveleetcode'))