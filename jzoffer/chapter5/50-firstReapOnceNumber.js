/**
 * 
 * @param {*} array 
 */
function getFirstReapOnceNumber(array) {
  let map = new Map()
  for (let item of array) {
    if (map.has(item)) {
      map.set(item, map.get(item) + 1)
    } else {
      map.set(item, 1)
    }
  }
  for (let item of array) {
    if (map.get(item) === 1) return item
  }
  return null
}

/**
 * 删除str中重复的字符 只保留第一个
 * @param {String} str 
 */
function deleteReaptedChar(str) {
  let set = new Set(), res = ''
  for (let char of str) {
    if (!set.has(char)) {
      res += char
      set.add(char)
    } 
  }
  return res
}

/**
 * 一个值包含ascii码的str
 * @param {String} str1
 * @param {String} str2
 */
function checkAnagram(str1, str2) {
  let remember = Array(256).fill(0)
  for (let i = 0; i < str1.length; i++) {
    remember[str1.charCodeAt(i) - 97]++
  }
  for (let i = 0; i < str2.length; i++) {
    remember[str2.charCodeAt(i) - 97]--
  }
  for (let res of remember) {
    if (res !== 0) return false 
  }
  return true
}

console.log(checkAnagram('silent', 'listeneeee'))
console.log(deleteReaptedChar('google'))
console.log(getFirstReapOnceNumber('abaccdeff'))