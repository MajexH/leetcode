/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
  let sum = 0
  for (let i = 0; i < s.length; i++) {
    sum = sum * 26 + charToNumber(s[i])
  }
  return sum
};

/**
 * 
 * @param {String} character 
 */
function charToNumber(character) {
  return character.charCodeAt(0) - 64
}

console.log(titleToNumber('AB'))