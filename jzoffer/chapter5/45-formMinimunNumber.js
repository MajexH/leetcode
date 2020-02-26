/**
 * 寻找array数组能够组成的最小数字
 * 特殊的比较 规则
 * @param {Array} array 
 */
function formMinimunNumber(array) {
  array.sort((a, b) => (a + '' + b) - (b + '' + a))
  let res = '';
  for (let item of array) {
    res += item
  }
  return formatResult(res)
}

function formatResult(res) {
  for (let i = 0; i < res.length; i++) {
    if (res[i] !== '0') {
      return res.slice(i, res.length)
    }
  }
  return '0'
}

console.log(formMinimunNumber([3,32,321]))