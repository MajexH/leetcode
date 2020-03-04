/**
 * 翻转一个字符串 的空格之间的字母的顺序
 * @param {String} str 
 */
function reverseString(str) {
  let strArray = [], temp = ''
  for (let i = 0; i < str.length; i++) {
    if (str.charAt(i) !== ' ') {
      temp += str.charAt(i)
    } else {
      strArray.push(temp)
      temp = ''
    }
  }
  strArray.push(temp)
  let res = ''
  for (let i = strArray.length - 1; i >= 0; i--) {
    res += strArray[i] + ' '
  }
  res = res.substring(0, res.length - 1)
  return res
}

console.log(reverseString('i am a student.'))

/**
 * 把左边的n个字符 移到str的右边
 * @param {String} str 
 * @param {number} n
 */
function leftReverseString(str, n) {
  if (str === null || str === undefined) return null
  return str.substring(n) + str.substring(0, n)
}

console.log(leftReverseString('abcdefg', 10))