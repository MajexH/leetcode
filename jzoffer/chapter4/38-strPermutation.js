/**
 * 给定一个字符串 给出其所有排列 包括
 * 如 abc 字符串 最后可以得到 abc acb bac bca cab cba
 * @param {String} str
 * @returns {Array}
 */
function strPermutation(str) {
  let res = [], strArray = str.split("")
  recursion(strArray, res, 0)
  return res
}

/**
 * 
 * @param {Array} str 
 * @param {Array} res 
 * @param {Number} start
 */
function recursion(str, res, start) {
  if (start >= str.length) {
    res.push(str.join(""))
    return
  }
  for (let i = start; i < str.length; i++) {
    swap(str, start, i)
    recursion(str, res, start + 1)
    swap(str, start, i)
  }
}

/**
 * 
 * @param {Array} str 
 * @param {number} i 
 * @param {number} j 
 */
function swap(str, i, j) {
  let temp = str[j]
  str[j] = str[i]
  str[i] = temp
}

console.log(strPermutation('abc'))