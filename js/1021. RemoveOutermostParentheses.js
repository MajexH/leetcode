/**
 * @param {string} S
 * @return {string}
 */
var removeOuterParentheses = function(S) {
  let result = '', level = 0;
  for (let item of S) {
    if (item !== ')') {
      if (item === '(') {
        level++;
      }
      result += level > 1 ? item : ''
    } else {
      result += level === 1 ? '' : item
      level--;
    }
  }
  return result
};

console.log(removeOuterParentheses("()()"))