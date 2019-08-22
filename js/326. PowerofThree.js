/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfThree = function(n) {
  if (n <= 0) return false
  while (n > 1) {
    n /= 3
    if (n.toString().indexOf('.') !== -1) return false
  }
  return true
};