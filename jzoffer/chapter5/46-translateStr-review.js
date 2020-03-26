/**
 * 将给定的数组 翻译成 字母表示的
 * 其中 0 - 'a' 1 - 'b' ………… 25 - 'z'
 * 求 num 能被翻译成的次数
 * @param {Number} num 
 */
function translateStrWithRecursion(num) {
  console.log(recursion(num.toString(), 0))
  console.log(recursionWithMemo(num.toString(), 0, new Map()))
}

/**
 * 
 * @param {Number} num 
 */
function translateStrWithoutRecursion(num) {
  let numStr = num.toString()
  // dp[i] 表示 以i为届 之后的数儿 能形成几个
  let dp = Array(numStr.length + 1).fill(0)
  dp[numStr.length] = 1
  for (let i = numStr.length; i >= 0; i--) {
    for (let j = 1; j <= 2; j++) {
      // 需要保证当前的index不越界 并且 是合法的数字
      if (i + j <= numStr.length && check(numStr, i, i + j))
        dp[i] += dp[i + j]
    }
  }

  return dp[0]
}

function recursion(num, index) {
  if (index === num.length) {
    return 1
  }
  let tempRes = 0
  for (let i = 1; i <= 2; i++) {
    if (index + i <= num.length && check(num, index, index + i))
      tempRes += recursion(num, index + i)
  }
  return tempRes
}

function recursionWithMemo(num, index, memo) {
  if (index === num.length) {
    return 1
  }
  if (memo.has(index)) return memo.get(index)
  let tempRes = 0
  for (let i = 1; i <= 2; i++) {
    if (index + i <= num.length && check(num, index, index + i))
      tempRes += recursionWithMemo(num, index + i, memo)
  }
  memo.set(index, tempRes)
  return tempRes
}

// 有前导0的是不行的
function check(num, start, end) {
  if (end - start > 1 && num.charAt(start) === '0') return false
  let tempNumber = Number.parseInt(num.substring(start, end))
  return tempNumber >= 0 && tempNumber <= 25
}

console.log(translateStrWithRecursion(506))
console.log(translateStrWithoutRecursion(502))