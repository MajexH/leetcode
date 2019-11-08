/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
  while (num.toString().length > 1) {
    let temp = 0
    for (let item of num.toString()) {
      temp += Number.parseInt(item)
    }
    num = temp
  }
  return num
};

console.log(addDigits(38))