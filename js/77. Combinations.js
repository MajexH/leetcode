/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let result = []
  recursion(n, k, result, [])
  return result
};

function recursion(n, k, result, temp) {
  if (k === 0) {
    result.push(JSON.parse(JSON.stringify(temp)))
    return
  }
  for (let i = n; i >= 1; i--) {
    temp.push(i)
    recursion(i - 1, k - 1, result, temp)
    temp.pop()
  }
}

console.log(combine(4, 2))