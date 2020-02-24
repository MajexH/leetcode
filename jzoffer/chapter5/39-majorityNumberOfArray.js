
/**
 * 数组中有一个出现次数 超过n/2的数 找到他
 * @param {Array} array 
 */
function getMarjorityNumberOfArray(array) {
  if (array.length === 0) return null
  let number, count = 0
  // 找到数字
  for(let item of array) {
    if (count === 0) {
      number = item
      count++
    } else if (number === item) {
      count++
    } else {
      count--
    }
  }
  count = 0
  // 检查数字 是否超过半数
  for (let item of array) {
    if (item === number) count++
  }
  return count > Math.floor((array.length) / 2) ? number : null
}

console.log(getMarjorityNumberOfArray([1,2,2,2,2,2,3]))