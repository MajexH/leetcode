/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
  if (n === 1) return true
  if (n <= 0) return false
  while (n > 1) {
    if (n.toString().indexOf('.') !== -1) {
      return false
    }
    n = n / 2
  }
  return true
};

console.log(isPowerOfTwo(218))