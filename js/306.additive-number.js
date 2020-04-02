/*
 * @lc app=leetcode id=306 lang=javascript
 *
 * [306] Additive Number
 */
/**
 * @param {string} num
 * @return {boolean}
 */
var isAdditiveNumber1 = function(num) {
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
// @lc code=start
/**
 * @param {string} num
 * @return {boolean}
 */
var isAdditiveNumber = function(num) {
  // 第一个是遍历 第一个数字
  for (let i = 1; i <= Math.floor(num.length / 2); i++) {
    // 第二个是遍历 第二个数字
    for (let j = 1; Math.max(i, j) <= num.length - i - j; j++) {
      if (isValid(num, i, j)) return true
    }
  }
  return false;
};

function isValid(num, i, j) {
  // '01' 这种是不被接受的
  if (num[0] === '0' && i > 1) return false
  if (num[i] === '0' && j > 1 ) return false
  let num1 = Number.parseInt(num.substring(0, i))
  let num2 = Number.parseInt(num.substring(i, i + j))
  // str 来保存 临时结果 这样就可以知道下个
  let str = ''

  for (let index = i + j; index <+ num.length; index += str.length) {
    num2 = num1 + num2
    num1 = num2 - num1
    str = num2.toString()
    // 判断下个地方是否是这个位置开始的字符串
    // 就是前面两个数的和 是否 是这个位置开始的 字符串的头
    // 如果是 再去遍历下一个位置
    if (!num.startsWith(num2.toString(), index)) return false
  }
  return true
}
// @lc code=end

console.log(isAdditiveNumber("199001200"))