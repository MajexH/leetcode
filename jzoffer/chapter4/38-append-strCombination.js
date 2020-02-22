/**
 * 得到所有数字的组合 例如 abc 可以得到
 * a b c ab ac bc abc
 * @param {String} str 
 */
function getStrCombination(str) {
  let res = []
  // js中string是imortal的 因此转换成array 好做一点儿
  let strArray = str.split('')
  for (let resArray of recursion(strArray, 0)) {
    res.push(resArray.join(''))
  }
  return res
}

/**
 * 
 * @param {Array} array 
 */
function recursion(array, start) {
  let temp = []
  if (start >= array.length) {
    return temp
  }
  for (let tempArray of recursion(array, start + 1)) {
    temp.push([array[start], ...tempArray])
    temp.push(tempArray)
  }
  temp.push([array[start]])

  return temp
}

console.log(getStrCombination('abc'))