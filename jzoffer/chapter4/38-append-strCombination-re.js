/**
 * 获取所有的 str 的字母的组合
 * 如 abc 可以组合成 a b c ab ac abc 几种
 * @param {String} str 
 */
function strCombination(str) {
  let strArray = str.split('')
  return recursion(strArray, 0)
}

/**
 * recursion的思路就是 在里面的逻辑是处理当前的所有结果
 * 当start + 1 时 其实是去找后面的所有结果
 * 再跟前面的 组合起来
 * @param {String[]} str 
 * @param {Number} start 
 */
function recursion(str, start) {
  // 保存当前的所有结果
  let temp = []
  if (start >= str.length) {
    return temp
  }
  for (let tempArray of recursion(str, start + 1)) {
    temp.push([str[start], ...tempArray])
    temp.push(tempArray)
  }
  temp.push([str[start]])
  // 返回当前的所有结果
  return temp
}

console.log(strCombination('abc'))