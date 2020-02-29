/**
 * 找到这个字符串里面的最长非重复子串
 * @param {String} str 
 */
function findLongest(str) {
  // position保存之前遇到的字符的位置
  let position = Array(26).fill(-1), maxLength = Number.MIN_SAFE_INTEGER
  // 保存局部的结果
  let curLength = 0
  for (let i = 0; i < str.length; i++) {
    let prePosition = position[str.charCodeAt(i) - 97]
    // 之前未遇到这个字符 或者 这个字符上次的位置 出现在当前的最长子串之前
    if (prePosition < 0 || i - prePosition > curLength) {
      curLength++
    } else {
    // 遇到过这个字符了
      maxLength = Math.max(curLength, maxLength)
      // 遇到这个字符 而且 这个字符在现在的最长子串中 因此 最长子串需要变短
      curLength = i - prePosition
    }
    position[str.charCodeAt(i) - 97] = i
  }
  // 如果整个都没有重复 需要在最后比较
  maxLength = Math.max(curLength, maxLength)
  return maxLength
}

console.log(findLongest('arabcacfr'))