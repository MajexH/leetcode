/**
 * 检查输入的str是否是一个合法的数值型string
 * 一个合法的数值型的str表示为 符号位 + 整数 + '.' + 整数 + 'e|E' + 符号位 + 整数
 * @param {String} str 
 * @returns {boolean}
 */
function check(str) {
  let { flag, index } = checkInteger(str, 0)

  if (str.charAt(index++) === '.') {
    // 扫描小数
    let res = checkUnsignedInteger(str, index)
    flag = flag && res.flag
    index = res.index
  }

  if (str.charAt(index) === 'e' || str.charAt(index) === 'E') {
    index++
    let res = checkUnsignedInteger(str, index)
    flag = flag && res.flag
    index = res.index
  }
  return flag && index === str.length - 1
}

/**
 * 检查从str的start开始的位置后面的数儿是不是有符号整数 第一位是符号位
 * @param {String} str 
 * @param {number} start 
 */
function checkInteger(str, start) {
  if (str.charAt(start) === '+' || str.charAt(start) === '-')
    start++
  return checkUnsignedInteger(str, start)
}

/**
 * 检查从str的start开始的位置后面的数儿是不是整数
 * @param {String} str 
 * @param {number} start 
 */
function checkUnsignedInteger(str, start) {
  // 如果 这个 integer是由数字组成的 就返回true
  let flag = false
  // 找到结尾 或者 找到一个不是数字的数儿
  while (start < str.length && str.charCodeAt(start) > 48 && str.charCodeAt(start) < 57) {
    start++
    flag = true
  }
  return {
    flag,
    index: start
  }
}

console.log(check('12ee+5.4'))