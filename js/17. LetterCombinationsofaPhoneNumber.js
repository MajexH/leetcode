let phone = [
  ['a', 'b', 'c'],
  ['d', 'e', 'f'],
  ['g', 'h', 'i'],
  ['j', 'k', 'l'],
  ['m', 'n', 'o'],
  ['p', 'q', 'r', 's'],
  ['t', 'u', 'v'],
  ['w', 'x', 'y', 'z']
]

function resolve(re, digits, result) {
  // 停止条件
  if (digits.length === 0) {
    result.push(re);
  } else {
    let digit = digits.substring(0, 1);
    for (let letter of phone[parseInt(digit) - 2]) {
      resolve(re + letter, digits.substring(1), result)
    }
  }
}
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  let result = []
  if (digits.length === 0 ) 
    return result
  resolve('', digits, result);
  return result;
};

console.log(letterCombinations("23"))