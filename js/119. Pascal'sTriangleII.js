/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
  return recursion(rowIndex)
};

function recursion(index) {
  if (index === 0) return [1]
  let pre = recursion(index - 1)
  let temp = []
  for (let i = 0; i <= index; i++) {
    if (i === 0 || i === index) {
      temp[i] = 1
    } else {
      temp[i] = pre[i - 1] + pre[i]
    }
  }
  return temp
}

console.log(getRow(3))