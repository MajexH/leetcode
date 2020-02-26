/**
 * 假设 0 - a ……………… 25 - z
 * 给定一个只包含 0-9数字的字符串 问将其通过上面的规则
 * 能够转换成多少种之后的字符串
 * 通过recursion去遍历所有的结果
 * 现在换个思路
 * @param {String} str 
 */
function translateStrWithRecursion(str) {
  let res = {
    count: 0
  }
  recursionWithoutReturnAllRes(str, 0, res)
  console.log(res.count)
  let memo = Array(str.length + 1).fill(-1)
  let second = recursionWithReturnAllRes(str, 0, memo)
  console.log(second.length)
}

/**
 * 
 * @param {String} str 
 */
function translateStrWithOutRecursion(str) {
  // dp[i] 代表之后的数儿能形成的次数
  let dp = Array(str.length).fill(0)
  dp[str.length - 1] = 1
  for (let i = str.length - 2; i >= 0; i--) {
    // 因为 可以形成两位数 所以有两种情况
    for (let j = 1; j <= 2; j++) {
      if (i + j <= str.length && validateNumber(str.substring(i, i + j))) {
        dp[i] += dp[i + j]
      }
    }
  }
  return dp[0]
}  

/**
 * 
 * @param {String} str 
 * @param {Number} start 
 * @param {Object} res 
 */
function recursionWithoutReturnAllRes(str, start, res) {
  if (start === str.length) {
    res.count++
    return
  }
  // 最多只会有两位
  for (let i = 1; i <= 2; i++) {
    if (start + i <= str.length && validateNumber(str.substring(start, start + i))) {
      recursionWithoutReturnAllRes(str, start + i, res)
    }
  }
}

/**
 * 与上一个recursion不同的是 这个地方直接返回之后的所有结果
 * 因此可以用memo来记录所有的结果
 * @param {String} str 
 * @param {Number} start 
 */
function recursionWithReturnAllRes(str, start, memo) {
  // temp 用来记录所有的结果
  let temp = []
  // 达到最后一个 说明这是一种可能的情况
  if (start === str.length) {
    return temp
  }
  if (memo[start] !== -1)
    return memo[start]
  for (let i = 1; i <= 2; i++) {
    let tempStr = str.substring(start, start + i)
    if (start + i <= str.length && validateNumber(tempStr)) {
      let res = recursionWithReturnAllRes(str, start + i, memo)
      if (res.length === 0) temp.push([tempStr])
      else {
        for (let array of res) {
          temp.push([tempStr, ...array])
        }
      }
    }
  }
  memo[start] = temp
  return temp
}
/**
 * 
 * @param {String} str 
 */
function validateNumber(str) {
  let temp = Number.parseInt(str)
  return temp >= 0 && temp <= 25
}

console.log(translateStrWithRecursion('122584532351234513452355231512345125123451345345'))
console.log(translateStrWithOutRecursion('122584532351234513452355231512345125123451345345'))