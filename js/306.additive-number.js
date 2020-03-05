/*
 * @lc app=leetcode id=306 lang=javascript
 *
 * [306] Additive Number
 */

// @lc code=start
/**
 * @param {string} num
 * @return {boolean}
 */
var isAdditiveNumber = function(num) {
  return recursion(num, 0, [], 0)
};
/**
 * @param {string} num
 * @param {number} start
 * @param {number[]} temp
 * @return {boolean}
 */
function recursion(num, start, temp, index) {
  if (start >= num.length) {
    return index > 2 ? true : false
  }
  let flag = false
  for (let i = start + 1; i <= num.length; i++) {
    let number = formatNumber(num, start, i)
    if (number === null) break
    if (temp.length < 2) {
      temp.push(number)
      flag = recursion(num, i, temp, index + 1)
      if (!flag) temp.pop()
    }
    else if (temp.length === 2) {
      let tempNumber = temp[0] + temp[1]
      if (tempNumber === number) {
        temp.push(temp[0] + temp[1])
        let remember = temp.shift()
        flag = recursion(num, i, temp, index + 1)
        if (!flag) {
          temp.unshift(remember)
          temp.pop()
        }
      } else if (tempNumber < number) {
        break
      }
    }
    if (flag) break
  }
  return flag
}

// 单独的0是可以的 但是 02 01 这种有前导0的不行
function formatNumber(num, start, i) {
  if (num.substring(start, i) === '0') return 0
  let flag = true
  for (let j = start; j < i; j++) {
    if (flag && num.charAt(j) === '0') {
      return null
    }
    if (num.charAt(j) !== '0')
      break
  }
  return Number.parseInt(num.substring(start, i))
}
// @lc code=end

console.log(isAdditiveNumber("199100199"))