/**
 * @param {number} n
 * @return {number[]}
 */
var grayCode1 = function(n) {
  let cur = Array(n).fill(0), result = []
  result.push(cur.join(''))
  for (let i = 1; i < Math.pow(2, n); i++) {
    let index = -1;
    do {
      if (index !== -1) {
        cur[index] = cur[index] === 1 ? 0 : 1
      }
      index = changeNumber(cur, n)
    } while (result.includes(cur.join('')))
    result.push(cur.join(''))
  }
  return result.map((value) => {
    return binaryToDecimal(value, n)
  })
};

function changeNumber(cur, n) {
  let index = Math.round(Math.random() * (n - 1))
  cur[index] = cur[index] === 1 ? 0 : 1
  return index
}

function binaryToDecimal(str, n) {
  let result = 0;
  for (let i = 0, j = n - 1; i < n; i++, j--) {
    result += Math.pow(2, j) * (str[i] - '0')
  }
  return result
}

/**
 * graycode 格雷码有自己的生成规则
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function(n) {
  let result = []
  for (let i = 0; i < Math.pow(2, n); i++) {
    result.push(i ^ (i >> 1))
  }
  return result
};

console.log(grayCode(3))