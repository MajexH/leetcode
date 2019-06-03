/**
 * @param {number} num
 * @return {number[]}
 */
var countBits = function(num) {
  let res = []
  for (let i = 0; i <= num; i++) {
    res.push(transferToBinary(i))
  }
  return res
};

function transferToBinary(num) {
  let res = 0;
  while (num !== 0) {
    if (num % 2 === 1)
      res++
    num = Math.floor(num / 2)
  }
  return res
}

console.log(countBits(16))