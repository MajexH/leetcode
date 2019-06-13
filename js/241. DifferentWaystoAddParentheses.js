/**
 * @param {string} input
 * @return {number[]}
 */
var diffWaysToCompute = function(input) {
  return recursion(input, 0, input.length, [])
};

function recursion(input, start, end, memo) {
  let temp = [], isNumber = true
  for (let i = start; i < end; i++) {
    let char = input[i]
    if (char === '-' || char === '*' || char === '+') {
      isNumber = false
      let left = recursion(input, start, i), right = recursion(input, i + 1, end)
      for (let leftItem of left) {
        for (let rightItem of right) {
          switch (char) {
            case '-':
              temp.push(leftItem - rightItem)
              break
            case '+':
              temp.push(leftItem + rightItem)
              break
            case '*':
              temp.push(leftItem * rightItem)
              break
          }
        }
      }
    }
  }
  if (isNumber) {
    temp.push(Number.parseInt(input.substring(start, end)))
  }
  return temp
}

console.log(diffWaysToCompute('2*3-4*5'))