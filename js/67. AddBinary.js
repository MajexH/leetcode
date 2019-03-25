/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
  let add = 0, i = a.length - 1, j = b.length - 1, result = [];
  while (true) {
    let temp = (i >= 0 ? Number.parseInt(a[i]) : 0) + (j >= 0 ? Number.parseInt(b[j]) : 0) + add;
    add = Math.floor(temp / 2);
    result.unshift(temp % 2);
    i--;
    j--;
    if (i < 0 && j < 0) {
      break;
    }
  }
  if (add !== 0) {
    result.unshift(add)
  }
  return result.join('');
};

console.log(addBinary("1010", "1011"));