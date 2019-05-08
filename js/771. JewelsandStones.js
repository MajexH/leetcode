/**
 * @param {string} J
 * @param {string} S
 * @return {number}
 */
var numJewelsInStones = function(J, S) {
  let set = new Set(J), result = 0
  for (let item of S) {
    if (set.has(item))
      result++;
  }
  return result
};

console.log(numJewelsInStones('aA', 'aAAbbb'))