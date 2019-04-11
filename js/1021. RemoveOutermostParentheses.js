/**
 * @param {string} S
 * @return {string}
 */
var removeOuterParentheses = function(S) {
  let stack = [], result = '';
  for (let item of S) {
    if (item !== ')') {
      stack.push(item)
      continue;
    }
    if (item === ')') {
      let temp = '', stackItem
      if (stack.length > 1) {
        do {
          stackItem = stack.pop();
          temp += stackItem
        } while (stack.length > 1 && stackItem !== '(') 
        result += temp.split("").reverse().join("");
        result += item;
      } else {
        stack.pop()
      }
    }
  }
  return result
};

console.log(removeOuterParentheses("(()(()))"))