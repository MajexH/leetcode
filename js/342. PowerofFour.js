/**
 * @param {number} num
 * @return {boolean}
 */
var isPowerOfFour = function(num) {
  while (num > 1) {
    if (num.toString().indexOf('.') !== -1) {
      return false
    }
    num /= 4
  }
  if (num !== 1) return false
  return true
};