/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} ops
 * @return {number}
 */
var maxCount = function(m, n, ops) {
  for (let item of ops) {
    m = Math.min(item[0], m)
    n = Math.min(item[1], n)
  }
  return m * n
};