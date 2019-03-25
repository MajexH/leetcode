/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
  let pattern = {
    M: 1000,
    CM: 900,
    D: 500,
    CD: 400,
    C: 100,
    XC: 90,
    L: 50,
    XL: 40,
    X: 10,
    IX: 9,
    V: 5,
    IV: 4,
    I: 1
  };
  let result = '';
  while (num > 0) {
    for (let i in pattern) {
      if (num >= pattern[i]) {
        num = num - pattern[i];
        result += i;
        break;
      }
    }
  }
  return result
};

console.log(intToRoman(1994))