/**
 * @param {number} n
 * @return {string}
 */
var convertToTitle = function(n) {
  let res = ''
  while (n > 0) {
    res = numberToChar((n - 1) % 26) + res
    n = Math.floor((n - 1) / 26);
  }
  return res
};

function numberToChar(number) {
  return String.fromCharCode(number + 65)
}

console.log(convertToTitle(701))