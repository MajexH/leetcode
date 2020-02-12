/**
 * 根据给出的patter的正则表达式 来判断str是否满足
 * 其中 正则表达式 只支持 . 和 *
 * @param {String} str 
 * @param {String} pattern 
 * @returns {Boolean}
 */
function isMatch(str, pattern) {
  return recursion(str, pattern, 0, 0)
}

/**
 * 
 * @param {String} str 
 * @param {String} pattern
 * @param {Boolean}
 */
function recursion(str, pattern, indexS, indexP) {
  // 终止条件
  if (indexS === str.length && indexP === pattern.length) 
    return true
  // 在有*存在的情况的 可以匹配0次到多次 因此不能在 str访问完了的时候  而pattern没访问完 就判断不能匹配
  if (indexS !== str.length && indexP === pattern.length) 
    return false
  // 越界 失配
  if (indexS > str.length || indexP > pattern.length) return false
  // 失配的情况
  if (pattern.charAt(indexP + 1) === '*') {
    // 如果当前的是匹配的
    if ((pattern.charAt(indexP) === '.' && indexS !== str.length) || pattern.charAt(indexP) === str.charAt(indexS)) {
      // 因此 当前分为三种情况 一种是匹配0次 一种是匹配多次 一种是 跳过这个*的
              // 结束匹配
      return recursion(str, pattern, indexS + 1, indexP + 2) || 
              // 匹配多次
              recursion(str, pattern, indexS + 1, indexP) ||
              // 匹配0次
              recursion(str, pattern, indexS, indexP + 2)
    } else {
      return recursion(str, pattern, indexS, indexP + 2)
    }
  }
  // 匹配的情况
  if (pattern.charAt(indexP) === '.' || pattern.charAt(indexP) === str.charAt(indexS)) {
    return recursion(str, pattern, indexS + 1, indexP + 1)
  } 
  return false
}

console.log(isMatch('', '.'))