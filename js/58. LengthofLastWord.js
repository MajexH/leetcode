/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
  let result = 0;
  for (let i = s.length - 1; i >= 0; i--) {
    if (s[i] === ' ') {
      if (result !== 0)
        break;
      else
        continue;
    }
    result++;
  }
  return result;
};

console.log(lengthOfLastWord("a "))