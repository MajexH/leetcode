/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
  return recursion(s, 0, 1, new Map())
};

/**
 * 这种感觉都是类似于全排列 还有 昨天(6.5)的95题很像
 * 这种东西都是类似一个全排列 就是有一个生成树
 * 可以通过递归去遍历整颗树
 * 因为每次遍历的子树他不是返回一个可能的结果
 * 所以 每层都有一个temp去保存当前层数的所有可能结果 然后返回给上一层 通过上一层进行排列组合
 * @param {string} str 
 * @param {number} start 
 * @param {number} level 
 * @param {Map} memo
 */
function recursion(str, start, level, memo) {
  if (memo.has(start + '-' + level)) {
    return memo.get(start + '-' + level)
  }
  let temp = []
  // 最多只能有4个分位数 所以是结束递归条件
  if (level === 4) {
    if (validate(str.substring(start, str.length))) {
      temp.push(str.substring(start, str.length))
    } 
    return temp
  } 
  // 点分计法的ip地址 每位不能超过三个数的长度 所以对每位的三个位置的可能结果进行遍历
  for (let i = 1; i <= 3; i++) {
    // 只有下个开始位置是合理的 才去遍历
    if (start + i < str.length) {
      let array = recursion(str, start + i, level + 1, memo)
      for (let item of array) {
        if (validate(str.substring(start, start + i))) {
          temp.push(str.substring(start, start + i) + '.' + item)
        } 
      }
    }
  }
  memo.set(start + '-' + level, temp)
  return temp
}

/**
 * 
 * @param {String} str 
 */
function validate(str) {
  if (str.length === 0 || str.length > 3 || (str.length > 1 && str.charAt(0) === '0'))
    return false
  return Number.parseInt(str) < 256
}

console.log(restoreIpAddresses("222255"))