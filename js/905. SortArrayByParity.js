/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParity = function(A) {
  let even = [], odd = []
  for (let item of A) {
    if (item % 2 === 0) even.push(item)
    else odd.push(item)
  }
  return [...even, ...odd]
};