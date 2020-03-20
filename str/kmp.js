/**
 * 
 * @param {String} str 
 */
function getNext(str) {
  let next = [-1]
  let k = -1, j = 0
  while (j < str.length - 1) {
    if (k === -1 || str.charAt(k) === str.charAt(j)) {
      ++k
      ++j
      next[j] = k
    } else {
      k = next[k]
    }
  }
  return next
}

/**
 * 
 * @param {String} str 
 * @param {String} pattern
 */
function kmp(str, pattern) {
  let i = 0, j = 0
  let next = getNext(pattern)
  while (i < str.length && j < pattern.length) {
    // 如果匹配
    if (j === - 1 || str.charAt(i) === pattern.charAt(j)) {
      i++
      j++
    } else {
    // 失配 更新j值
      j = next[j]
    }
  }
  if (j === pattern.length)
    return i - j;
  else
    return -1;
}

console.log(kmp("bbcabcdababcdabcdabde", "abcdabd"))
