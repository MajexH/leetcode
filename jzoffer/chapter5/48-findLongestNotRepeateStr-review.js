/**
 * 找到 str 中不含重复数字的最长子串
 * @param {String} str 
 */
function findLongest(str) { 
  // memo 记录一个字母上次出现的位置
  let memo = new Map()
  let max = 0, currentLength = 0
  for (let i = 0; i < str.length; i++) {
    if (!memo.has(str.charAt(i))) {
      currentLength++
    } else {
      let pre = memo.get(str.charAt(i))
      if (i - pre > currentLength) {
        currentLength++
      } else {
        max = Math.max(max, currentLength)
        currentLength = i - pre
      }
    }
    memo.set(str.charAt(i), i)
  }
  max = Math.max(max, currentLength)
  return max
}

console.log(findLongest(" "))