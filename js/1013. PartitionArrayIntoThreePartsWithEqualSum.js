/**
 * @param {number[]} A
 * @return {boolean}
 */
var canThreePartsEqualSum = function(A) {
  let sum = (A.reduce((pre, cur) => pre + cur, 0))
  if (sum % 3 !== 0) {
    return false
  }
  return recursion(1, 0, sum / 3, A)
};

/**
 * 
 * @param {number} level 代表这是第几个数 
 * @param {number} start 
 * @param {number} target
 * @param {Array} array 
 */
function recursion(level, start, target, array) {
  if (level > 3) return false
  let sum = 0
  for (let i = start; i < array.length; i++) {
    sum += array[i]
    if (target === sum) {
      // 如果能够两次拿到sum 这整体剩下的一定是sum
      if (level === 3) {
        // let temp = 0
        // for (let j = i + 1; j < array.length; j++) {
        //   temp += array[j]
        // }
        // if (i === array.length - 1 || temp === 0)
        return true
      }
      else return true && recursion(level + 1, i + 1, target, array)
    }
  }
  return false
}

console.log(canThreePartsEqualSum([0,2,1,-6,6,7,9,-1,2,0,1]))