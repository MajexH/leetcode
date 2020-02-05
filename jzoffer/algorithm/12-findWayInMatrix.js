/**
 * 判断在array的数组中，是否有target的路径
 * @param {Array[]} array 
 * @param {String} target 
 * @returns {boolean}
 */
function findWayInMatrix(array, target) {
  let memo = Array(array.length)
  for (let i = 0; i < memo.length; i++)
    memo[i] = Array(array[i].length).fill(false)
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length; j++) {
      if (array[i][j] === target.charAt(0)) {
        return recursion(array, target, memo, i, j, 0)
      }
    }
  }
}

function recursion(array, target, memo, i, j, index) {
  if (i >= array.length || j >= array[0].length || i < 0 || j < 0) return false
  if (index === target.length) return true
  if (array[i][j] === target.charAt(index) && memo[i][j] === false){
    memo[i][j] = true
    let res =  recursion(array, target, memo, i + 1, j, index + 1) ||
          recursion(array, target, memo, i, j + 1, index + 1) ||
          recursion(array, target, memo, i - 1, j, index + 1) ||
          recursion(array, target, memo, i, j - 1, index + 1)
    if (!res) memo[i][j] = false
    return res
  }
  else return false
}

// 测试用例
let matrix = [
  ['a', 'b', 't', 'g'],
  ['c', 'f', 'c', 's'],
  ['j', 'd', 'e', 'h']
]

console.log(findWayInMatrix(matrix, 'bfce'))