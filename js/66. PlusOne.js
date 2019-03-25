/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  let add = 0, n = digits.length;
  let temp = digits[n - 1] + 1;
  add = Math.floor(temp / 10);
  digits[n - 1] = temp % 10;
  for (let i = n - 2; i >= 0; i--) {
    if (add === 0) {
      break;
    }
    let temp = digits[i] + add;
    add = Math.floor(temp / 10);
    digits[i] = temp % 10;
  }
  if (add !== 0) {
    digits.unshift(add)
  }
  return digits;
};

console.log(plusOne([9]))