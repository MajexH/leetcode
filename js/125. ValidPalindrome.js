/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
  let i = 0, j = s.length - 1
  while (i < j) {
    if (!isAlphanumeric(s[i])) {
      i++
      continue
    }
    if (!isAlphanumeric(s[j])) {
      j--
      continue
    }
    if (s[i] !== s[j] && !((s[i] > 'Z' || s[j] > 'Z') && Math.abs(s[i].charCodeAt(0) - s[j].charCodeAt(0)) === 32)) {
      return false
    }
    i++
    j--
  }
  return true
};

/**
 * 
 * @param {String} s 
 */
function isAlphanumeric(s) {
  let temp = s.charCodeAt(0)
  if ((temp < 91 && temp > 64) || (temp < 123 && temp > 96) || (temp > 47 && temp < 58)) {
    return true
  }
  return false
}

console.log(isPalindrome("0P"))